package Testpackage;

import static org.testng.Assert.assertEquals;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testclass {

	int additionValue = 8;
	int subtractValue = 2;
	int multiplicationValue = 15;
	
@Test
public void addition() {
	int a = 5;
	int b=3;
	int c;
	c =+ a;
	System.out.println(c);
	int finaladd = b+c;
	if (finaladd == additionValue) {
		Assert.assertTrue(true);
	}
	else {
		Assert.assertTrue(false);
	}
	
}
@Test
public void subtraction() {
	int a = 5;
	int b=3;
	int finalsub = a-b;
	assertEquals(finalsub, subtractValue);	
}
@Test
public void multiply() {
	int a = 5;
	int b=3;
	int finalmult = a*b;
	assertEquals(finalmult, multiplicationValue);	
}


}
