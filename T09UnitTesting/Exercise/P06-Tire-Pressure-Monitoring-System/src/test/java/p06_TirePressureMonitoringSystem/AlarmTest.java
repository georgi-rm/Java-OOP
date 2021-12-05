package p06_TirePressureMonitoringSystem;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class AlarmTest {
    private static final double LOW_PRESSURE_VALUE = 16;
    private static final double HIGH_PRESSURE_VALUE = 22;
    private static final double Normal_PRESSURE_VALUE = 17;


    @Test
    public void testAlarmIsOffOnNormalPreasure() {
        Sensor mockedSensor = Mockito.mock(Sensor.class);
        Mockito.when(mockedSensor.popNextPressurePsiValue()).thenReturn(Normal_PRESSURE_VALUE);
        Alarm alarm = new Alarm(mockedSensor);
        alarm.check();
        assertFalse(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmOnLowPressure() {
        Sensor mockedSensor = Mockito.mock(Sensor.class);
        Mockito.when(mockedSensor.popNextPressurePsiValue()).thenReturn(LOW_PRESSURE_VALUE);
        Alarm alarm = new Alarm(mockedSensor);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmOnHighPressure() {
        Sensor mockedSensor = Mockito.mock(Sensor.class);
        Mockito.when(mockedSensor.popNextPressurePsiValue()).thenReturn(HIGH_PRESSURE_VALUE);
        Alarm alarm = new Alarm(mockedSensor);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }
}