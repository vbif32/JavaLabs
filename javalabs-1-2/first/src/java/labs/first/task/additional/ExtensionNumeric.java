package labs.first.task.additional;

import labs.first.CommonNumeric;

/**
 *
 * Additional class for the first lab
 */
public interface ExtensionNumeric extends CommonNumeric {

    public ExtensionNumeric add(CommonNumeric bigIntegerCommon);

    public ExtensionNumeric subtract(CommonNumeric bigIntegerCommon);

    public ExtensionNumeric multiply(CommonNumeric bigIntegerCommon);

    public ExtensionNumeric devide(CommonNumeric bigIntegerCommon);

    public ExtensionNumeric factorial();

    public boolean isFloat();
}
