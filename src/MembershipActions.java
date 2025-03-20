package src;

import java.sql.Connection;

public interface MembershipActions {
    void enrollMember(GymMember member);

    void viewMembers();
}
