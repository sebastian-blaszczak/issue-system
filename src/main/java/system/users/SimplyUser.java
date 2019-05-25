package system.users;


import com.sun.javafx.binding.StringFormatter;
import javafx.beans.binding.StringExpression;
import system.observers.ObserverMethod;
import system.users.exceptions.WrongRoleExceptions;
import system.users.interfaces.UserBehavior;

public class SimplyUser extends User {
    public SimplyUser(String name, String surname, RoleType role, UserBehavior behavior) {
        super(name, surname, role, behavior);
        if (RoleType.ADMIN.equals(role)) {
            throw new WrongRoleExceptions("Wrong Role");
        }
    }

    @Override
    public void notify(ObserverMethod method) {
        StringExpression message = StringFormatter.format("User name = [%s] is notified", this.getName());
        System.out.println(message.getValue());
        method.execute();
    }
}
