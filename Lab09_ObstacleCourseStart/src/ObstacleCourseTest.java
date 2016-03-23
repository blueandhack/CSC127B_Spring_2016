import static org.junit.Assert.*;

import org.junit.Test;

public class ObstacleCourseTest {

	ObstacleCourse top = new ObstacleCourse("top.txt");

	ObstacleCourse noExit = new ObstacleCourse("noway.txt");

	ObstacleCourse right = new ObstacleCourse("right.txt");

	ObstacleCourse bottom = new ObstacleCourse("bottom.txt");

	ObstacleCourse left = new ObstacleCourse("left.txt");

	ObstacleCourse big = new ObstacleCourse("big");

	@Test
	public void testStartRowAndStartColumnForSixCourses() {

		assertEquals(5, top.getStartRow());
		assertEquals(7, top.getStartColumn());

		assertEquals(3, noExit.getStartRow());
		assertEquals(1, noExit.getStartColumn());

		assertEquals(6, right.getStartRow());
		assertEquals(2, right.getStartColumn());

		assertEquals(2, bottom.getStartRow());
		assertEquals(3, bottom.getStartColumn());

		assertEquals(4, left.getStartRow());
		assertEquals(3, left.getStartColumn());
	}

	@Test
	public void testGetExitRowMustBeNegativeOneBeforeFindExit() {
		assertEquals(-1, noExit.getExitRow());
		assertEquals(-1, noExit.getExitColumn());

		assertEquals(-1, top.getExitRow());
		assertEquals(-1, top.getExitColumn());

		assertEquals(-1, right.getExitRow());
		assertEquals(-1, right.getExitColumn());

		assertEquals(-1, bottom.getExitRow());
		assertEquals(-1, bottom.getExitColumn());

		assertEquals(-1, left.getExitRow());
		assertEquals(-1, left.getExitColumn());
	}

	@Test
	public void testGetExitRowWhenExitIsToTheNorth() {
		top.findTheExit(5, 7);
		assertEquals(0, top.getExitRow());
		assertEquals(6, top.getExitColumn());
	}

	@Test
	public void testGetExitRowWhenExitIsToTheEast() {
		right.findTheExit(6, 2);
		assertEquals(1, right.getExitRow());
		assertEquals(9, right.getExitColumn());
	}

	@Test
	public void testGetExitRowWhenExitIsToTheSouth() {
		bottom.findTheExit(2, 3);
		assertEquals(7, bottom.getExitRow());
		assertEquals(1, bottom.getExitColumn());
	}

	@Test
	public void testGetExitRowWhenExitIsToTheWest() {
		left.findTheExit(6, 2);
		assertEquals(3, left.getExitRow());
		assertEquals(0, left.getExitColumn());
	}

	@Test
	public void testGetExitRowWhenExitIsToTheWestInAReallyBigCourse() {
		big.findTheExit(6, 2);
		assertEquals(0, big.getExitRow());
		assertEquals(14, big.getExitColumn());
	}

	@Test
	public void testGetExitRowMustBeNegativeOneWhenThereIsNoExit() {
		noExit.findTheExit(3, 1);
		assertEquals(-1, noExit.getExitRow());
		assertEquals(-1, noExit.getExitColumn());
		noExit.toString();
	}

}
