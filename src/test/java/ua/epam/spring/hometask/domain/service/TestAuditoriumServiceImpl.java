package ua.epam.spring.hometask.domain.service;

import org.junit.Test;

import javax.annotation.Resource;

import ua.epam.spring.hometask.domain.SetupTest;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.service.UserService;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class TestAuditoriumServiceImpl extends SetupTest {


  @Resource
  private UserService userService;

  @Resource
  private User newUser;

  //test covers save(), getAll()
  @Test
  public void saveUserTest(){
    userService.save(newUser);
    User userFromService=userService.getById(newUser.getId());
    assertTrue(userFromService.getFirstName().equals(newUser.getFirstName()));
    assertTrue(userFromService.getLastName().equals(newUser.getLastName()));
    assertTrue(userFromService.getBirthday().equals(newUser.getBirthday()));
    assertTrue(userFromService.getEmail().equals(newUser.getEmail()));
    assertTrue(userFromService.getBalance()==newUser.getBalance());
  }



  @Test
  public void getUserByIdTest(){
    User userFromService=userService.getById(newUser.getId());
    assertTrue(userFromService.getId().equals(newUser.getId()));
  }

  @Test
  public void getUserByEmailTest(){
    User userFromService=userService.getUserByEmail(newUser.getEmail());
    assertTrue(userFromService.getEmail().equals(newUser.getEmail()));
  }

  @Test
  public void getAllUsersTest(){
    assertTrue(userService.getAll().size()==1);
  }

  @Test
  public void removeUserTest(){
    userService.remove(newUser);
    assertNull(userService.getById(newUser.getId()));
  }


}
