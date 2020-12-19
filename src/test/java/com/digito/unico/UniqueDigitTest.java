package com.digito.unico;

import com.digito.unico.service.OperationUniqueDigitService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class UniqueDigitTest {
    @Test
    public void testCalcUniqueDigit() {
        String n = "9875";
        int k = 4;

        OperationUniqueDigitService operationUniqueDigitService = new OperationUniqueDigitService();
        int result = operationUniqueDigitService.computeUniqueDigit(n, k);

        assertEquals(8, result);
    }

    @Test
    public void testCalcUniqueDigitBig() {
        String n = "9831243224154275";
        int k = 99999;

        OperationUniqueDigitService operationUniqueDigitService = new OperationUniqueDigitService();
        int result = operationUniqueDigitService.computeUniqueDigit(n, k);

        assertEquals(9, result);
    }

    @Test
    public void testCalcUniqueDigitBiggest() {
        String n = "874368742439847489327412091321423131452750765765";
        int k = 99999;

        OperationUniqueDigitService operationUniqueDigitService = new OperationUniqueDigitService();
        int result = operationUniqueDigitService.computeUniqueDigit(n, k);

        assertEquals(9, result);
    }

    @Test
    public void testCalcUniqueDigitFalse() {
        String n = "9875";
        int k = 4;

        OperationUniqueDigitService operationUniqueDigitService = new OperationUniqueDigitService();
        int result = operationUniqueDigitService.computeUniqueDigit(n, k);

        assertNotEquals(1, result);
    }

    @Test
    public void testCalcUniqueDigitBigFalse() {
        String n = "9831243224154275";
        int k = 99999;

        OperationUniqueDigitService operationUniqueDigitService = new OperationUniqueDigitService();
        int result = operationUniqueDigitService.computeUniqueDigit(n, k);

        assertNotEquals(4, result);
    }

    @Test
    public void testCalcUniqueDigitBiggestFalse() {
        String n = "874368742439847489327412091321423131452750765765";
        int k = 99999;

        OperationUniqueDigitService operationUniqueDigitService = new OperationUniqueDigitService();
        int result = operationUniqueDigitService.computeUniqueDigit(n, k);

        assertNotEquals(3, result);
    }

    @Test
    public void testGetUniqueDigit() {
        String n = "45";

        OperationUniqueDigitService operationUniqueDigitService = new OperationUniqueDigitService();
        int result = operationUniqueDigitService.getUniqueDigit(n);

        assertEquals(9, result);
    }

    @Test
    public void testGetUniqueDigitBig() {
        String n = "45392139817313832731";

        OperationUniqueDigitService operationUniqueDigitService = new OperationUniqueDigitService();
        int result = operationUniqueDigitService.getUniqueDigit(n);

        assertEquals(2, result);
    }

    @Test
    public void testGetUniqueDigitBiggest() {
        String n = "45392139321312423534543635423423421423142348973982740921749817313832731";

        OperationUniqueDigitService operationUniqueDigitService = new OperationUniqueDigitService();
        int result = operationUniqueDigitService.getUniqueDigit(n);

        assertEquals(9, result);
    }

    @Test
    public void testGetUniqueDigitFalse() {
        String n = "45";

        OperationUniqueDigitService operationUniqueDigitService = new OperationUniqueDigitService();
        int result = operationUniqueDigitService.getUniqueDigit(n);

        assertNotEquals(1, result);
    }

    @Test
    public void testGetUniqueDigitBigFalse() {
        String n = "45392139817313832731";

        OperationUniqueDigitService operationUniqueDigitService = new OperationUniqueDigitService();
        int result = operationUniqueDigitService.getUniqueDigit(n);

        assertNotEquals(5, result);
    }

    @Test
    public void testGetUniqueDigitBiggestFalse() {
        String n = "45392139321312423534543635423423421423142348973982740921749817313832731";

        OperationUniqueDigitService operationUniqueDigitService = new OperationUniqueDigitService();
        int result = operationUniqueDigitService.getUniqueDigit(n);

        assertNotEquals(8, result);
    }

    @Test
    public void testGetSubstrings() {
        String n = "45";
        int lenPartition = n.length() % 4 == 0 ? n.length() / 4 : (int) Math.ceil((double) n.length() / 4) ;

        OperationUniqueDigitService operationUniqueDigitService = new OperationUniqueDigitService();
        List<String> strings = operationUniqueDigitService.getSubstrings(lenPartition, n);

        assertEquals(1, strings.get(0).length());
    }

    @Test
    public void testGetSubstringsBig() {
        String n = "45392139817313832731";
        int lenPartition = n.length() % 4 == 0 ? n.length() / 4 : (int) Math.ceil((double) n.length() / 4) ;

        OperationUniqueDigitService operationUniqueDigitService = new OperationUniqueDigitService();
        List<String> strings = operationUniqueDigitService.getSubstrings(lenPartition, n);

        assertEquals(5, strings.get(0).length());
    }

    @Test
    public void testGetSubstringsBiggest() {
        String n = "45392139321312423534543635423423421423142348973982740921749817313832731";
        int lenPartition = n.length() % 4 == 0 ? n.length() / 4 : (int) Math.ceil((double) n.length() / 4) ;

        OperationUniqueDigitService operationUniqueDigitService = new OperationUniqueDigitService();
        List<String> strings = operationUniqueDigitService.getSubstrings(lenPartition, n);

        assertEquals(18, strings.get(0).length());
    }

    @Test
    public void testGetSubstringsFalse() {
        String n = "45";
        int lenPartition = n.length() % 4 == 0 ? n.length() / 4 : (int) Math.ceil((double) n.length() / 4) ;

        OperationUniqueDigitService operationUniqueDigitService = new OperationUniqueDigitService();
        List<String> strings = operationUniqueDigitService.getSubstrings(lenPartition, n);

        assertNotEquals(2, strings.get(0).length());
    }

    @Test
    public void testGetSubstringsBigFalse() {
        String n = "45392139817313832731";
        int lenPartition = n.length() % 4 == 0 ? n.length() / 4 : (int) Math.ceil((double) n.length() / 4) ;

        OperationUniqueDigitService operationUniqueDigitService = new OperationUniqueDigitService();
        List<String> strings = operationUniqueDigitService.getSubstrings(lenPartition, n);

        assertNotEquals(7, strings.get(0).length());
    }

    @Test
    public void testGetSubstringsBiggestFalse() {
        String n = "45392139321312423534543635423423421423142348973982740921749817313832731";
        int lenPartition = n.length() % 4 == 0 ? n.length() / 4 : (int) Math.ceil((double) n.length() / 4) ;

        OperationUniqueDigitService operationUniqueDigitService = new OperationUniqueDigitService();
        List<String> strings = operationUniqueDigitService.getSubstrings(lenPartition, n);

        assertNotEquals(17, strings.get(0).length());
    }
}
