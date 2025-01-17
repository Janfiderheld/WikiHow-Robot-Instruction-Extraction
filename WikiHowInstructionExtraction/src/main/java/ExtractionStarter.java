import analysis.*;
import io.JSONFileReader;
import io.ResultVisualizer;
import io.StepFilter;
import model.DeconstructedStepSentence;
import model.WikiHowStep;
import model.verbs.*;
import nlp.CoreferenceResolver;
import nlp.PoSTagger;
import nlp.SentencePartsExtractor;
import utils.GlobalSettings;

import java.util.ArrayList;

public class ExtractionStarter {

    private static ArrayList<IStepAnalyzer> stepAnalyzers = new ArrayList<>();
    private static ArrayList<ISentenceAnalyzer> sentenceAnalyzers = new ArrayList<>();

    public static void main(String[] args) {
        JSONFileReader reader = new JSONFileReader();
        ResultVisualizer visualizer = new ResultVisualizer();
        PoSTagger.initialize();
        addAnalyzers();

        ArrayList<WikiHowStep> unfilteredSteps = reader.extractStepsFromFiles();
        if(args.length > 0 && args[0].equals("hyponyms")) {
            VerbHyponymCountAnalyzer.analyzeHyponyms(unfilteredSteps, CuttingVerbWordVerbNet.values());

            if(!GlobalSettings.OVERVIEW_EXTRACTION) {
                ArrayList<DeconstructedStepSentence> sentences = new ArrayList<>();
                for (CuttingVerbWordVerbNet verb : CuttingVerbWordVerbNet.values()) {
                    ArrayList<WikiHowStep> steps = StepFilter.filterGivenSteps(unfilteredSteps, verb);
                    sentences.addAll(SentencePartsExtractor.deconstructStepsIntoSentenceParts(steps, verb));
                }
                visualizer.visualizeResults(null, sentences);
            }
            return;
        }

        if (args.length > 0) {
            ISearchableVerb[] verbs = switch (args[0]) {
                case "pour" -> PouringVerb.values();
                case "pickplace" -> PickOrPlaceVerb.values();
                case "detect" -> DetectVerb.values();
                case "perceive" -> PerceiveVerb.values();
                case "cook" -> CookVerb.values();
                case "cool" -> CoolVerb.values();
                default -> null;
            };

            if (verbs != null) {
                VerbHyponymCountAnalyzer.analyzeHyponyms(unfilteredSteps, verbs);
                return;
            }
        }

        if(GlobalSettings.GET_CORPUS_META) {
            CorpusDataPrinter.printResults();
            return;
        }

        ArrayList<WikiHowStep> steps = StepFilter.filterGivenSteps(unfilteredSteps);
        System.out.println(steps.size() + " steps containing \"" + GlobalSettings.searchVerb.getPresentForm() + "\"\n");
        callStepAnalyzers(steps);

        ArrayList<DeconstructedStepSentence> sentences = new ArrayList<>();
        if(!GlobalSettings.OVERVIEW_EXTRACTION) {
            sentences = SentencePartsExtractor.deconstructStepsIntoSentenceParts(steps, GlobalSettings.searchVerb);
            CoreferenceResolver.resolveCoreferences(sentences);
            callSentenceAnalyzers(sentences);
            System.out.println(sentences.size() + " sentences containing \"" + GlobalSettings.searchVerb.getPresentForm() + "\"" +
                    (GlobalSettings.FILTER_BEFORE_PART ? " and \"" + GlobalSettings.beforeFilterString + "\"" : "") +
                    (GlobalSettings.FILTER_SENTENCE ? " and \"" + GlobalSettings.sentenceFilterString + "\"" : "") +
                    (GlobalSettings.FILTER_AFTER_PART ? " and \"" + GlobalSettings.afterFilterString + "\"" : ""));
        }
        visualizer.visualizeResults(steps, sentences);
    }

    private static void addAnalyzers() {
        if(GlobalSettings.OCCURRENCE_PRINTING) {
            stepAnalyzers.add(new VerbOccurrencePrinter());
        }

        if(GlobalSettings.CATEGORY_DISTRIBUTION) {
            stepAnalyzers.add(new CategoryDistributionAnalyzer());
        }

        if(GlobalSettings.IMAGE_VIDEO_COUNTER) {
            stepAnalyzers.add(new ImageAndVideoCounter());
        }

        if(!GlobalSettings.OVERVIEW_EXTRACTION && GlobalSettings.SENTENCE_PARTS_ANALYSIS) {
            sentenceAnalyzers.add(new SentencePartAnalysis());
        }

        if(!GlobalSettings.OVERVIEW_EXTRACTION && GlobalSettings.PREPOSITION_DISTRIBUTION) {
            sentenceAnalyzers.add(new PrepositionDistributionAnalyzer());
        }

        if(!GlobalSettings.OVERVIEW_EXTRACTION) {
            sentenceAnalyzers.add(new MeasurementOccurrencePrinter());
        }

        sentenceAnalyzers.add(new CoreferenceAnalyzer());
    }

    private static void callStepAnalyzers(ArrayList<WikiHowStep> steps) {
        for(IStepAnalyzer analyzer : stepAnalyzers) {
            System.out.print("# " + analyzer.getClass().getSimpleName() + " results:\n");
            analyzer.analyzeAndPrintResults(steps);
            System.out.print("\n");
        }
    }

    private static void callSentenceAnalyzers(ArrayList<DeconstructedStepSentence> sentences) {
        for(ISentenceAnalyzer analyzer : sentenceAnalyzers) {
            System.out.print("# " + analyzer.getClass().getSimpleName() + " results:\n");
            analyzer.analyzeAndPrintResults(sentences);
            System.out.print("\n");
        }
    }
}