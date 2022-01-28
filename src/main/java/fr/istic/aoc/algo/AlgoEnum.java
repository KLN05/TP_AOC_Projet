package fr.istic.aoc.algo;

public enum AlgoEnum {
	ALGO_ATOM("ALGO_ATOM"),
    ALGO_SEQ("ALGO_SEQ");
    
    private String algo;

    AlgoEnum(String algo) {
        this.algo = algo;
    }

    public String getAlgo() {
        return algo;
    }
}

