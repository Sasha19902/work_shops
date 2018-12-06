package workshop.interfaces;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.io.IOException;

public class TestUserManager {

    private static final String DEFULT_ROLE = "default";

    @Test
    public void testAdd() throws IOException, UserManagerException {
        String name = "Vasya";
        ICollection iCollection = Mockito.mock(ICollection.class);
        UserManager userManager = new UserManager(iCollection);

        userManager.createDefault(name);

        Mockito.doAnswer((Answer<User>) invocationOnMock -> {
            User user1 = invocationOnMock.getArgument(0);
            Assert.assertEquals(user1.getName(), name);
            Assert.assertEquals(user1.getRole(), DEFULT_ROLE);
            return user1;
        }).when(iCollection).add(Mockito.any(User.class));
    }

    @Test
    public void testGet() throws UserManagerException, IOException {
        User user = new User("Vasya", "Vodila");
        ICollection iCollection = Mockito.mock(ICollection.class);
        UserManager userManager = new UserManager(iCollection);

        Mockito.when(iCollection.get(0)).thenReturn(user);
        User expend = userManager.getUserByIndex(0);

        Assert.assertEquals(user.getRole(), expend.getRole());
        Assert.assertEquals(user.getName(), expend.getName());
    }


    @Test(expected = UserManagerException.class)
    public void testThrowCreateException() throws IOException, UserManagerException {
        ICollection collection = Mockito.mock(ICollection.class);
        UserManager userManager = new UserManager(collection);

        Mockito.doThrow(IOException.class).when(collection).add(Mockito.any(User.class));
        userManager.createDefault("");
    }

    @Test(expected = UserManagerException.class)
    public void testThrowGetException() throws IOException, UserManagerException {
        ICollection collection = Mockito.mock(ICollection.class);
        UserManager userManager = new UserManager(collection);

        Mockito.doThrow(IOException.class).when(collection).get(Mockito.any(long.class));
        userManager.getUserByIndex(5);
    }
}
