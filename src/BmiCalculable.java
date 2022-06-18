public interface BmiCalculable {
     enum statusEnum {
        UNDERWEIGHT,
        NORMAL_WEIGHT,
        OVERWEIGHT,
        DANGEROUS_OVERWEIGHT
    }

    double calculateIdealWeight(double height);

    double calculateBmi(double weight, double height);

    statusEnum evaluateBmi(double bmi);

    boolean evaluateNormalizedBmi(int age, double bmi);
}
