package hw3;

import exceptions.IndexException;
import hw3.list.MeasuredIndexedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MeasuredIndexedListTest {

  private static final int LENGTH = 15;
  private static final int DEFAULT_VALUE = 3;

  private MeasuredIndexedList<Integer> measuredIndexedList;

  @BeforeEach
  void setup() {
    measuredIndexedList = new MeasuredIndexedList<>(LENGTH, DEFAULT_VALUE);
  }

  @Test
  @DisplayName("MeasuredIndexedList starts with zero reads")
  void zeroReadsStart() {
    assertEquals(0, measuredIndexedList.accesses());
  }

  @Test
  @DisplayName("MeasuredIndexedList starts with zero writes")
  void zeroWritesStart() {
    assertEquals(0, measuredIndexedList.mutations());
  }
  
  @Test
  @DisplayName("Get() doesn't increment access if IndexException is thrown")
  void GetDoesNotChangeAccessIfIndexException() {
    try {
      int value = measuredIndexedList.get(16);
    } catch (IndexException ex) {
    
    }
    assertEquals(0, measuredIndexedList.accesses());
  }
  
  @Test
  @DisplayName("Count() correctly increments access")
  void CountCorrectlyIncrementAccess() {
    assertEquals(LENGTH, measuredIndexedList.count(DEFAULT_VALUE));
    assertEquals(LENGTH, measuredIndexedList.accesses());
  }
}
