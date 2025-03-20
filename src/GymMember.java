package src;

public abstract class GymMember {
        private String name;
        private int id;
        private double weight;
        private double height;
        private String membershipPlan;
        private String paymentOption;
        private char gender;
        private int age;
        private String trainingType;
        private String trainingSlot;

        public GymMember(String name, int id, double weight, double height, String membershipPlan,
                         String paymentOption, char gender, int age, String trainingType, String trainingSlot) {
            this.name = name;
            this.id = id;
            this.weight = weight;
            this.height = height;
            this.membershipPlan = membershipPlan;
            this.paymentOption = paymentOption;
            this.gender = gender;
            this.age = age;
            this.trainingType = trainingType;
            this.trainingSlot = trainingSlot;
        }

        public abstract void displayInfo();

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        public double getWeight() {
            return weight;
        }

        public double getHeight() {
            return height;
        }

        public String getMembershipPlan() {
            return membershipPlan;
        }

        public String getPaymentOption() {
            return paymentOption;
        }

        public String getGender() {
            String gen= new String(String.valueOf(gender));
            return gen;
        }

        public int getAge() {
            return age;
        }

        public String getTrainingType() {
            return trainingType;
        }

        public String getTrainingSlot() {
            return trainingSlot;
        }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setMembershipPlan(String membershipPlan) {
        this.membershipPlan = membershipPlan;
    }

    public void setPaymentOption(String paymentOption) {
        this.paymentOption = paymentOption;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTrainingType(String trainingType) {
        this.trainingType = trainingType;
    }

    public void setTrainingSlot(String trainingSlot) {
        this.trainingSlot = trainingSlot;
    }
}
