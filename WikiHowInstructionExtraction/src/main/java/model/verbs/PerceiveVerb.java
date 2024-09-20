package model.verbs;

public enum PerceiveVerb implements ISearchableVerb {
    ACHE("ache", "ached", "aching"),
    APPERCEIVE("apperceive", "apperceived", "apperceiving"),
    CATCH("catch", "caught", "catching"),
    COMPREHEND("comprehend", "comprehended", "comprehending"),
    DESCRY("descry", "descried", "descrying"),
    DISCOVER("discover", "discovered", "discovering"),
    DIVINE("divine", "divined", "divining"),
    DREAM("dream", "dreamt", "dreaming"),
    ESPY("espy", "espied", "espying"),
    EXAMINE("examine", "examined", "examining"),
    EXPERIENCE("experience", "experienced", "experiencing"),
    EYE("eye", "eyed", "eying"),
    FEEL("feel", "felt", "feeling"),
    FIND("find", "found", "finding"),
    GLIMPSE("glimpse", "glimpsed", "glimpsing"),
    HALLUCINATE("hallucinate", "hallucinated", "hallucinating"),
    HEAR("hear", "heard", "hearing"),
    HURT("hurt", "hurt", "hurting"),
    INSPECT("inspect", "inspected", "inspecting"),
    INVESTIGATE("investigate", "investigated", "investigating"),
    LISTEN("listen", "listened", "listening"),
    MAKE("make", "made", "making"),
    MISPERCEIVE("misperceive", "misperceived", "misperceiving"),
    NOTE("note", "noted", "noting"),
    OBSERVE("observe", "observed", "observing"),
    OVERHEAR("overhear", "overheard", "overhearing"),
    PERCEIVE("perceive", "perceived", "perceiving"),
    PERUSE("peruse", "perused", "perusing"),
    PICK("pick", "picked", "picking"),
    RECEIVE("receive", "received", "receiving"),
    RECOGNIZE("recognize", "recognized", "recognizing"),
    REGARD("regard", "regarded", "regarding"),
    SAVOR("savor", "savorred", "savorring"),
    SCAN("scan", "scanned", "scanning"),
    SCENT("scent", "scented", "scenting"),
    SCRUTINIZE("scrutinize", "scrutinized", "scrutinizing"),
    SEE("see", "saw", "seeing"),
    SENSE("sense", "sensed", "sensing"),
    SIGHT("sight", "sighted", "sighting"),
    SMELL("smell", "smelt", "smelling"),
    SNIFF("sniff", "sniffed", "sniffing"),
    SPOT("spot", "spotted", "spotting"),
    SPY("spy", "spied", "spying"),
    STUDY("study", "studied", "studying"),
    SUFFER("suffer", "suffered", "suffering"),
    SURVEY("survey", "surveyed", "surveying"),
    TASTE("taste", "tasted", "tasting"),
    TOUCH("touch", "touched", "touching"),
    VIEW("view", "viewed", "viewing"),
    WATCH("watch", "watched", "watching"),
    WITNESS("witness", "witnessed", "witnessing");

    private final String present;

    private final String past;

    private final String participle;

    PerceiveVerb(String verb, String past, String participle) {
        this.present = verb;
        this.past = past;
        this.participle = participle;
    }

    @Override
    public boolean doesPresentEqualPast() {
        return present.equals(past);
    }

    @Override
    public String getPresentForm() {
        return present;
    }

    @Override
    public String getPastForm() {
        return past;
    }

    @Override
    public String getParticipleForm() {
        return participle;
    }
}