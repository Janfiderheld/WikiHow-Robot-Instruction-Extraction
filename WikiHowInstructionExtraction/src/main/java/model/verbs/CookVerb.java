package model.verbs;

public enum CookVerb implements ISearchableVerb {
    ARRANGE("arrange", "arranged", "arranging"),
    ASSEMBLE("assemble", "assembled", "assembling"),
    BAKE("bake", "baked", "baking"),
    BARBECUE("barbecue", "barbecueed", "barbecueing"),
    BLANCH("blanch", "blanched", "blanching"),
    BLEND("blend", "blended", "blending"),
    BLOW("blow", "blew", "blowing"),
    BOIL("boil", "boiled", "boiling"),
    BRAISE("braise", "braised", "braising"),
    BREW("brew", "brewed", "brewing"),
    BROIL("broil", "broiled", "broiling"),
    BROWN("brown", "browned", "browning"),
    CAST("cast", "cast", "casting"),
    CHARBROIL("charbroil", "charbroiled", "charbroiling"),
    CHARCOALBROIL("charcoal-broil", "charcoal-broiled", "charcoal-broiling"),
    CHISEL("chisel", "chiselled", "chiselling"),
    CHURN("churn", "churned", "churning"),
    CLEAR("clear", "cleared", "clearing"),
    CODDLE("coddle", "coddled", "coddling"),
    COMPILE("compile", "compiled", "compiling"),
    CONCOCT("concoct", "concocted", "concocting"),
    COOK("cook", "cooked", "cooking"),
    CRISP("crisp", "crisped", "crisping"),
    CROCHET("crochet", "crocheted", "crocheting"),
    CULTIVATE("cultivate", "cultivated", "cultivating"),
    DEEPFRY("deep-fry", "deep-fried", "deep-frying"),
    DEGLAZE("deglaze", "deglazed", "deglazing"),
    DEVELOP("develop", "developed", "developing"),
    DEVIL("devil", "deviled", "deviling"),
    DRESS("dress", "dressed", "dressing"),
    EMBROIDER("embroider", "embroidered", "embroidering"),
    ERECT("erect", "erected", "erecting"),
    ESCALLOP("escallop", "escalloped", "escalloping"),
    FAKE("fake", "faked", "faking"),
    FALSIFY("falsify", "falsified", "falsifying"),
    FASHION("fashion", "fashioned", "fashioning"),
    FIX("fix", "fixed", "fixing"),
    FLAMBE("flambe", "flambed", "flambing"),
    FOLD("fold", "folded", "folding"),
    FORGE("forge", "forged", "forging"),
    FORMULATE("formulate", "formulated", "formulating"),
    FRENCHFRY("french-fry", "french-fried", "french-frying"),
    FRICASSEE("fricassee", "fricasseed", "fricasseeing"),
    FRY("fry", "fried", "frying"),
    FUDGE("fudge", "fudged", "fudging"),
    GRILL("grill", "grilled", "grilling"),
    GRIND("grind", "ground", "grinding"),
    GROW("grow", "grew", "growing"),
    HACK("hack", "hacked", "hacking"),
    HAMMER("hammer", "hammered", "hammering"),
    HARDBOIL("hardboil", "hardboiled", "hardboiling"),
    HATCH("hatch", "hatched", "hatching"),
    HEAT("heat", "het", "heating"),
    JUGGLE("juggle", "juggled", "juggling"),
    KEEP("keep", "kept", "keeping"),
    KNIT("knit", "knitted", "knitting"),
    LARD("lard", "larded", "larding"),
    LIGHT("light", "lighted", "lighting"),
    MAKE("make", "made", "making"),
    MANIPULATE("manipulate", "manipulated", "manipulating"),
    MICROCOOK("micro-cook", "micro-cooked", "micro-cooking"),
    MICROWAVE("microwave", "microwaved", "microwaving"),
    MISREPRESENT("misrepresent", "misrepresented", "misrepresenting"),
    MIX("mix", "mixed", "mixing"),
    MOLD("mold", "molded", "molding"),
    NUKE("nuke", "nuked", "nuking"),
    OVENFRY("oven-fry", "oven-fried", "oven-frying"),
    OVENPOACH("oven-poach", "oven-poached", "oven-poaching"),
    OVERCOOK("overcook", "overcooked", "overcooking"),
    OVERHEAT("overheat", "overheated", "overheating"),
    PANBROIL("pan-broil", "pan-broiled", "pan-broiling"),
    PANFRY("pan-fry", "pan-fried", "pan-frying"),
    PARBOIL("parboil", "parboiled", "parboiling"),
    PARCH("parch", "parched", "parching"),
    PERCOLATE("percolate", "percolated", "percolating"),
    PERK("perk", "perked", "perking"),
    PLANK("plank", "planked", "planking"),
    POACH("poach", "poached", "poaching"),
    POTROAST("pot-roast", "pot-roasted", "pot-roasting"),
    POUND("pound", "pounded", "pounding"),
    PRECOOK("precook", "precooked", "precooking"),
    PREPARE("prepare", "prepared", "preparing"),
    PRESERVE("preserve", "preserved", "preserving"),
    PRESSURECOOK("pressure-cook", "pressure-cooked", "pressure-cooking"),
    PUT("put", "put", "putting"),
    READY("ready", "readied", "readying"),
    REHEAT("reheat", "reheated", "reheating"),
    RISSOLE("rissole", "rissoled", "rissoling"),
    ROAST("roast", "roasted", "roasting"),
    ROLL("roll", "rolled", "rolling"),
    RUN("run", "ran", "running"),
    SAUTE("saute", "sauted", "sauting"),
    SCALD("scald", "scalded", "scalding"),
    SCALLOP("scallop", "scalloped", "scalloping"),
    SCULTPURE("scultpure", "scultpured", "scultpuring"),
    SEW("sew", "sewed", "sewing"),
    SHIRR("shirr", "shirred", "shirring"),
    SIMMER("simmer", "simmered", "simmering"),
    SOFTBOIL("softboil", "softboiled", "softboiling"),
    SOUSE("souse", "soused", "sousing"),
    SPIN("spin", "spun", "spinning"),
    STEAM("steam", "steamed", "steaming"),
    STEAMBAKE("steam-bake", "steam-baked", "steam-baking"),
    STEW("stew", "stewed", "stewing"),
    STIR("stir", "stirred", "stirring"),
    STITCH("stitch", "stitched", "stitching"),
    TOAST("toast", "toasted", "toasting"),
    TOSS("toss", "tossed", "tossing"),
    WANGLE("wangle", "wangled", "wangling"),
    WEAVE("weave", "wove", "weaving"),
    WHIP("whip", "whipped", "whipping"),
    WHITTLE("whittle", "whittled", "whittling"),
    WHOMP("whomp", "whomped", "whomping"),
    ZAP("zap", "zapped", "zapping");

    private final String present;

    private final String past;

    private final String participle;

    CookVerb(String verb, String past, String participle) {
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