package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ConverterTest {

    @Test
    void StringToInteger() {
        StringToIntegerConverter converter = new StringToIntegerConverter();
        Integer res = converter.convert("1000");
        assertThat(res).isEqualTo(1000);
    }

    @Test
    void IntegerToString() {
        IntegerToStringConverter converter = new IntegerToStringConverter();
        String res = converter.convert(1000);
        assertThat(res).isEqualTo("1000");
    }

    @Test
    void StringToIpPort() {
        StringToIpPortConverter converter = new StringToIpPortConverter();
        IpPort ipPort = converter.convert("127.0.0.1:8080");
        assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1", 8080));
    }

    @Test
    void IpPortToString() {
        IpPortToStringConverter converter = new IpPortToStringConverter();
        String res = converter.convert(new IpPort("127.0.0.1", 8080));
        assertThat(res).isEqualTo("127.0.0.1:8080");
    }
}
