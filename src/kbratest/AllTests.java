package kbratest;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({ PhpEvalCautionTest.class, PhpEvalTest.class })

public class AllTests {
}