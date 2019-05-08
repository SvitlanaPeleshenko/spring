package ua.epam.spring.hometask.domain.service;

import org.junit.Test;

import javax.annotation.Resource;

import ua.epam.spring.hometask.domain.Auditorium;
import ua.epam.spring.hometask.domain.SetupTest;
import ua.epam.spring.hometask.service.AuditoriumService;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestAuditoriumServiceImpl extends SetupTest {

  private static final String AUDITORIUM_1_CODE = "white-hall";
  private static final String AUDITORIUM_1_NAME = "White";

  @Resource
  private AuditoriumService auditoriumService;

  @Test
  public void getAllAuditoriumsTest() {
    assertFalse(auditoriumService.getAll().isEmpty());
  }

  @Test
  public void getByCodeTest() {
    Auditorium auditorium = auditoriumService.getByCode(AUDITORIUM_1_CODE);
    assertTrue(auditorium.getCode().equals(AUDITORIUM_1_CODE));
  }

  @Test
  public void getByNameTest() {
    Auditorium auditorium = auditoriumService.getByName(AUDITORIUM_1_NAME);
    assertTrue(auditorium.getName().equals(AUDITORIUM_1_NAME));
  }

}
