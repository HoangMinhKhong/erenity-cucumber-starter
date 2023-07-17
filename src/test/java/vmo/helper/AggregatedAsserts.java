package vmo.helper;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class AggregatedAsserts {
    private static final String NEW_LINE = System.lineSeparator();
    private List<Error> errors = new ArrayList<>();
    private boolean printStackTraces = false;

    /**
     * Executes JUnit assertEquals method. If {@link AssertionError} is thrown, error is
     * added to {@link #errors} and test does not fail.
     *
     * @param message  String the message for the {@link AssertionError}.
     * @param expected Object expected value.
     * @param actual   Object actual value.
     */
    public void assertEquals(String message, Object expected, Object actual) {
        try {
            Assert.assertEquals(message, expected, actual);
        } catch (AssertionError e) {
            errors.add(e);
        }
    }

    /**
     * Executes JUnit assertTrue method. If {@link AssertionError} is thrown, error is
     * added to {@link #errors} and test does not fail.
     *
     * @param message   String the message for the {@link AssertionError}.
     * @param condition boolean condition to be checked.
     */
    public void assertTrue(String message, boolean condition) {
        try {
            Assert.assertTrue(message, condition);
        } catch (AssertionError e) {
            errors.add(e);
        }
    }

    /**
     * Executes JUnit {@link Assert#assertNotNull} method. If {@link AssertionError} is
     * thrown, error is added to {@link #errors} and test does not fail.
     *
     * @param message String the message for the {@link AssertionError}.
     * @param object  {@link Object} to verify not null.
     */
    public void assertNotNull(String message, Object object) {
        try {
            Assert.assertNotNull(message, object);
        } catch (AssertionError e) {
            errors.add(e);
        }
    }

    /**
     * Executes JUnit Assert fail method. {@link AssertionError} is added to
     * {@link #errors} and test will not immediately fail.
     *
     * @param message String Error message for the {@link AssertionError}.
     */
    public void fail(String message) {
        try {
            Assert.fail(message);
        } catch (AssertionError e) {
            errors.add(e);
        }
    }

    /**
     * If list of errors {@link #errors} is not empty, fails test by throwing
     * {@link AssertionError} and prints the error messages.
     */
    public void processAllAssertions() {
        if (errors.isEmpty()) {
            System.out.println("No Assertion errors were thrown"); //replace with Logger if desired
        } else {
            StringBuilder msgBuilder = new StringBuilder();
            for (Error error : errors) {
                msgBuilder.append(NEW_LINE);
                msgBuilder.append(AssertionError.class.getSimpleName());
                msgBuilder.append(" ");
                msgBuilder.append(errors.indexOf(error) + 1);
                msgBuilder.append(": ");
                if (printStackTraces) {
                    msgBuilder.append(NEW_LINE);
                    msgBuilder.append(ExceptionUtils.getStackTrace(error)); //converts stack trace to String
                } else {
                    msgBuilder.append(error.getMessage());
                }
            }
            Assert.fail(errors.size() + " " + AssertionError.class.getSimpleName() + "(s) were thrown:" + NEW_LINE
                    + msgBuilder);
        }
    }

    /**
     * Includes the stack traces with the error messages when
     * {@link #processAllAssertions()} is called.
     */
    public void includeStackTraces() {
        this.printStackTraces = true;
    }
}
