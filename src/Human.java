public class Human implements BmiCalculable {


    String name;
    double weight;
    int age;
    double bmi;
    statusEnum status;
    double idealWeight;
    double height;
    boolean hasNormalizedBmi;
    String output;



    //constructor
    public Human(int age,double weight, double height, String name) {
        //Set base vars
        this.setName(name);
        this.setAge(age);
        this.setWeight(weight);
        this.setHeight(height);
        //Calculate Ideal weight
        height = this.getHeight();
        double idealWeight = this.calculateIdealWeight(height);
        this.setIdealWeight(idealWeight);
        //Get needed Vars for calculating bmi
        height = this.getHeight();
        weight = this.getWeight();
        //Calculate Bmi
        double bmi = this.calculateBmi(weight,height);
        //Set calculated Vars
        this.setIdealWeight(idealWeight);
        this.setBmi(bmi);
        //Evaluate Bmi
        bmi = this.getBmi();
        statusEnum status = this.evaluateBmi(bmi);
        this.setStatus(status);
        //Eval normalized Bmi
        age = this.getAge();
        boolean hasNormalizedBmi = evaluateNormalizedBmi(age,bmi);
        this.setHasNormalizedBmi(hasNormalizedBmi);
    }

    public static void main(){
        Human obelix = new Human(19,186,205,"Obelix");
        System.out.println(obelix.getOutput());
    }

    //get&set
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        if (weight > 0 && weight < 999) {
            this.weight = weight;
        } else {
            System.out.println("Weight can not be negative and over 999KG");
        }
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age > 0 && age < 100) {
            this.age = age;
        } else {
            System.out.println("A Human cannot be seriously older than 100 years and younger than 0 years");
        }

    }

    protected double getBmi() {
        return this.bmi;
    }

    protected void setBmi(double bmi) {
        if (bmi > 0) {
            this.bmi = bmi;
        } else {
            System.out.println("BMI Cannot be negative");
        }

    }

    protected double getHeight(){
        return this.height;
    }

    protected void setHeight(double height){
        if(height > 30 && height < 250){
            this.height = height;
        } else {
            System.out.println("Height cannot be smaller than 30cm and higher than 250cm");
        }
    }

    protected statusEnum getStatus() {
        return this.status;
    }

    protected void setStatus(statusEnum status) {
        this.status = status;
    }

    protected double getIdealWeight() {
        return this.idealWeight;
    }

    protected void setIdealWeight(double idealWeight) {
        this.idealWeight = idealWeight;
    }

    protected boolean getHasNormalizedBmi(){
        return this.hasNormalizedBmi;
    }

    protected void setHasNormalizedBmi(boolean hasNormalizedBmi){
        this.hasNormalizedBmi = hasNormalizedBmi;
    }

    public String getOutput(){
        return this.output;
    }

    public void setOutput(String output){
        this.output = output;
    }

    //Class methods

    public double calculateIdealWeight(double height){
        return height - 100;
    }

    public double calculateBmi(double weight, double height){
        return (weight / height*height) ;
    }

    public statusEnum evaluateBmi(double bmi){
        if (bmi < 18){
            return statusEnum.UNDERWEIGHT;
        } else if(bmi <= 26){
            return statusEnum.NORMAL_WEIGHT;
        } else if(bmi <= 32){
            return statusEnum.OVERWEIGHT;
        } else {
            return statusEnum.DANGEROUS_OVERWEIGHT;
        }
    }

    public boolean evaluateNormalizedBmi(int age, double bmi){

        //Generate init values
        int bmiMax;

        if(age > 19){
            return false;
        } else if (age >= 19 && age <= 24){
            bmiMax = 24;
        } else if(age >= 25 && age <= 44){
            bmiMax = 26;
        } else if(age >= 45 && age <= 54){
            bmiMax = 27;
        } else if(age >= 55 && age <= 64){
            bmiMax = 28;
        } else {
            bmiMax = 29;
        }

        int bmiMin = bmiMax-5;

        if (bmi >= bmiMin && bmi <= bmiMax){
            return true;
        } else{
            return false;
        }

    }

    public String constructOutput(){

         String message = "" +
                "Name: "+this.getName()+
                "Height:"+ this.getHeight()+
                "Weight:"+ this.getWeight() +
                "Optimal weight:" + this.getIdealWeight() +
                "Bmi:" + this.getBmi() +
                "State:"+ this.getStatus() +
                "Has normalized bmi:"+ this.getHasNormalizedBmi()
                ;

        return message;
    }



}
