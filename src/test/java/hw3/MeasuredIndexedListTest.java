package hw3;

import exceptions.IndexException;
import hw3.list.MeasuredIndexedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

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
      fail("Test failed!");
    } catch (IndexException ex) {
      System.out.println("Test Passed!");
    }
    assertEquals(0, measuredIndexedList.accesses());
  }
  
  @Test
  @DisplayName("Put() doesn't increment access if IndexException is thrown")
  void PutDoesNotChangeAccessIfIndexException() {
    try {
      measuredIndexedList.put(16, 1);
      fail("Test failed!");
    } catch (IndexException ex) {
      System.out.println("Test Passed!");
    }
    assertEquals(0, measuredIndexedList.mutations());
  }
  
  @Test
  @DisplayName("Count() correctly increments access")
  void CountCorrectlyIncrementAccess() {
    assertEquals(LENGTH, measuredIndexedList.count(DEFAULT_VALUE));
    assertEquals(LENGTH, measuredIndexedList.accesses());
  }
  
  @Test
  @DisplayName("accesses() is correct after list traversed")
  void AccessesIsCorrectAfterListTraverse() {
    for (int i = 0; i < LENGTH; i++) {
      measuredIndexedList.get(i);
    }
    assertEquals(LENGTH, measuredIndexedList.accesses());
  }
  
  @Test
  @DisplayName("mutations() is correct after list traversed")
  void MutationsIsCorrectAfterListTraverse() {
    for (int i = 0; i < LENGTH; i++) {
      measuredIndexedList.put(i, 4);
    }
    assertEquals(LENGTH, measuredIndexedList.mutations());
  }
  
  @Test
  @DisplayName("reset() correctly reset after list modification")
  void ResetIsCorrectAfterListModification() {
    for (int i = 0; i < LENGTH; i++) {
      measuredIndexedList.put(i, i);
    }
    for (int i = 0; i < LENGTH; i++) {
      measuredIndexedList.get(i);
    }
    
    measuredIndexedList.reset();
    assertEquals(0, measuredIndexedList.accesses());
    assertEquals(0, measuredIndexedList.mutations());
  }
  
}
