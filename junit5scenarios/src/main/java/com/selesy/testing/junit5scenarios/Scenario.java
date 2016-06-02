package com.selesy.testing.junit5scenarios;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.gen5.api.Test;

/**
 * Provides a replacement annotation for @Test which allows the test writer to
 * specify which tests are predecessors to others.  The ScenarioExtension will
 * attempt to order all tests such that there are no conflicts.  Cyclical
 * dependencies are not supported.
 * 
 * @author Steve Moyer &lt;smoyer1@selesy.com&gt;
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Test
public @interface Scenario {
  
  /**
   * Provides a list of test method names that are the predecessors of the
   * current test.  Each name must resolve to another method name in this
   * class (or a super-class) and each must also be annotated with @Scenario.
   * 
   * @return the list of test method names.
   */
  String[] predecessors() default {};

}
