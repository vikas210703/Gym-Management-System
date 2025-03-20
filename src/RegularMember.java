package src;

class RegularMember extends GymMember {
    public RegularMember(String name, int id, double weight, double height, String membershipPlan,
                         String paymentOption, char gender, int age, String trainingType, String trainingSlot) {
        super(name, id, weight, height, membershipPlan, paymentOption, gender, age, trainingType, trainingSlot);
    }

    public void displayInfo() {
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Weight: " + getWeight() + " kg");
        System.out.println("Height: " + getHeight() + " cm");
        System.out.println("Membership Plan: " + getMembershipPlan());
        System.out.println("Payment Option: " + getPaymentOption());
        System.out.println("Gender: " + getGender());
        System.out.println("Age: " + getAge());
        System.out.println("Training Type: " + getTrainingType());
        System.out.println("Training Slot: " + getTrainingSlot());
    }
}