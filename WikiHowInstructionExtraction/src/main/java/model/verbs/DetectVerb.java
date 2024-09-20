package model.verbs;

public enum DetectVerb implements ISearchableVerb {
    CATCH("catch", "catched", "catching"),
    DETECT("detect", "detected", "detecting"),
    DISCERN("discern", "discerned", "discerning"),
    DISCOVER("discover", "discovered", "discovering"),
    FEEL("feel", "felt", "feeling"),
    FIND("find", "found", "finding"),
    INSTANTIATE("instantiate", "instantiated", "instantiating"),
    NOTICE("notice", "noticed", "noticing"),
    OBSERVE("observe", "observed", "observing"),
    PERCEIVE("perceive", "perceived", "perceiving"),
    SEE("see", "saw", "seeing"),
    SENSE("sense", "sensed", "sensing"),
    TRACE("trace", "traced", "tracing");

    private final String present;

    private final String past;

    private final String participle;

    DetectVerb(String verb, String past, String participle) {
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