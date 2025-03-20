package src;

import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class Connector {
        private static final String DB_URL = "jdbc:mysql://localhost:3306/extra";
        private static final String USER = "root";
        private static final String PASSWORD = "Ankur@1234";

        private Connection connection;

        public Connector() {
            try {
                connection = getConnection(DB_URL, USER, PASSWORD);
                initializeDatabase();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void initializeDatabase() {
            try {
                String createTableQuery = "CREATE TABLE IF NOT EXISTS members (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), weight DOUBLE, height DOUBLE, membership_plan VARCHAR(255), payment_option VARCHAR(255), gender VARCHAR(255), age INT, training_type VARCHAR(255), training_slot VARCHAR(255))";
                connection.createStatement().executeUpdate(createTableQuery);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void insertMemberIntoDatabase(GymMember member) {
            try {
                String insertQuery = "INSERT INTO members (name, weight, height, membership_plan, payment_option, gender, age, training_type, training_slot) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                preparedStatement.setString(1, member.getName());
                preparedStatement.setDouble(2, member.getWeight());
                preparedStatement.setDouble(3, member.getHeight());
                preparedStatement.setString(4, member.getMembershipPlan());
                preparedStatement.setString(5, member.getPaymentOption());
                preparedStatement.setString(6, member.getGender());
                preparedStatement.setInt(7, member.getAge());
                preparedStatement.setString(8, member.getTrainingType());
                preparedStatement.setString(9, member.getTrainingSlot());

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public void searchMember(int memberId) {
            try {
                String searchQuery = "SELECT * FROM members WHERE id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(searchQuery);
                preparedStatement.setInt(1, memberId);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    System.out.println("Member found:");
                    System.out.println("ID: " + resultSet.getInt("id"));
                    System.out.println("Name: " + resultSet.getString("name"));
                    System.out.println("Weight: " + resultSet.getDouble("weight") + " kg");
                    System.out.println("Height: " + resultSet.getDouble("height") + " cm");
                    System.out.println("Membership Plan: " + resultSet.getString("membership_plan"));
                    System.out.println("Payment Option: " + resultSet.getString("payment_option"));
                    System.out.println("Gender: " + resultSet.getString("gender"));
                    System.out.println("Age: " + resultSet.getInt("age"));
                    System.out.println("Training Type: " + resultSet.getString("training_type"));
                    System.out.println("Training Slot: " + resultSet.getString("training_slot"));
                } else {
                    System.out.println("Member with ID " + memberId + " not found.");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void closeConnection() {
            try {
                if (connection != null) {
                    connection.close();
                    System.out.println("Connection closed");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


}
