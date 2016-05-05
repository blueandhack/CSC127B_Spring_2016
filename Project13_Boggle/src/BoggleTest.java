
/*
 * CSc 127B Spring 2016, Project 13
 *
 * Project Name: Boggle
 *
 * Author: Yujia Lin and Jiaxuan Chen 
 * ---
 * The test case for Boggle
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BoggleTest {

	// The method use to test Failed Get Score While Guessing Valid Words
	@Test
	public void testFailedGetScoreWhileGuessingValidWords() {
		char[][] trayA = {

				{ 'E', 'R', 'H', 'I' },

				{ 'T', 'C', 'O', 'Z' },

				{ 'I', 'E', 'S', 'E' },

				{ 'V', 'E', 'V', 'W' } };

		BoggleTray dt = new BoggleTray(trayA);
		Boggle game = new Boggle();
		game.setBoggleTray(dt);
		// System.out.println(dt.toString());

		assertEquals(0, game.getScore());
		game.addGuess("see");

		assertEquals(1, game.getScore());
		game.addGuess("tees");
		assertEquals(2, game.getScore());

		game.addGuess("echos");
		assertEquals(4, game.getScore());

		game.addGuess("secret");
		assertEquals(7, game.getScore());

		game.addGuess("recites");
		assertEquals(12, game.getScore());

		game.addGuess("receives");
		assertEquals(23, game.getScore());

		game.addGuess("secretive");
		assertEquals(34, game.getScore());
	}

	// The method use to test Failed Get Score While Guessing Correct Duplicate
	// Words
	@Test
	public void testFailedGetScoreWhileGuessingCorrectDuplicateWords() {

		char[][] trayA = {

				{ 'E', 'R', 'H', 'I' },

				{ 'T', 'C', 'O', 'Z' },

				{ 'I', 'E', 'S', 'E' },

				{ 'V', 'E', 'V', 'W' } };

		BoggleTray dt = new BoggleTray(trayA);
		Boggle game = new Boggle();
		game.setBoggleTray(dt);

		assertEquals(0, game.getScore());
		game.addGuess("see");
		assertEquals(1, game.getScore());
		game.addGuess("see");
		assertEquals(1, game.getScore());
		game.addGuess("tees");
		assertEquals(2, game.getScore());
		game.addGuess("tees");
		assertEquals(2, game.getScore());
		game.addGuess("echos");
		assertEquals(4, game.getScore());
		game.addGuess("echos");
		assertEquals(4, game.getScore());
		game.addGuess("secret");
		assertEquals(7, game.getScore());
		game.addGuess("secret");
		assertEquals(7, game.getScore());

		game.addGuess("recites");
		assertEquals(12, game.getScore());
		game.addGuess("recites");
		assertEquals(12, game.getScore());

		game.addGuess("receives");
		assertEquals(23, game.getScore());

		game.addGuess("receives");
		assertEquals(23, game.getScore());
	}

	// the method use to test Failed Get Score While Guessing Words That Do Not
	// Count For Points
	@Test
	public void testFailedGetScoreWhileGuessingWordsThatDoNotCountForPoints() {
		char[][] trayA = {

				{ 'E', 'R', 'H', 'I' },

				{ 'T', 'C', 'O', 'Z' },

				{ 'I', 'E', 'S', 'E' },

				{ 'V', 'E', 'V', 'W' } };

		BoggleTray dt = new BoggleTray(trayA);
		Boggle game = new Boggle();
		game.setBoggleTray(dt);
		assertEquals(0, game.getScore());
		game.addGuess("nothere");
		assertEquals(0, game.getScore());
		game.addGuess("xc");
		assertEquals(0, game.getScore());
		game.addGuess("xcdssdfsx");
		assertEquals(0, game.getScore());
		game.addGuess("abcdefertrtewdfsd");
		assertEquals(0, game.getScore());
		game.addGuess("queen");
		assertEquals(0, game.getScore());
		game.addGuess("plush");
		assertEquals(0, game.getScore());
		game.addGuess("another");
		assertEquals(0, game.getScore());
	}

	// the method use to test Failed Get Score While Guessing Variety Of Words
	@Test
	public void testFailedGetScoreWhileGuessingVarietyOfWords() {
		char[][] trayA = {

				{ 'E', 'R', 'H', 'I' },

				{ 'T', 'C', 'O', 'Z' },

				{ 'I', 'E', 'S', 'E' },

				{ 'V', 'E', 'V', 'W' } };

		BoggleTray dt = new BoggleTray(trayA);
		Boggle game = new Boggle();
		game.setBoggleTray(dt);

		game.addGuess("sEe");
		assertEquals(1, game.getScore());
		game.addGuess("TeEs");
		assertEquals(2, game.getScore());
		game.addGuess("EchoS");
		assertEquals(4, game.getScore());
		game.addGuess("dsdfsdf");
		assertEquals(4, game.getScore());
		game.addGuess("resume");
		assertEquals(4, game.getScore());
		game.addGuess("acidic");
		assertEquals(4, game.getScore());
	}

	// the method use to test Failed Get Words Found Are In Ascending Order
	@Test
	public void testFailedGetWordsFoundAreInAscendingOrder() {
		char[][] trayA = {

				{ 'E', 'R', 'H', 'I' },

				{ 'T', 'C', 'O', 'Z' },

				{ 'I', 'E', 'S', 'E' },

				{ 'V', 'E', 'V', 'W' } };

		BoggleTray dt = new BoggleTray(trayA);
		Boggle game = new Boggle();
		game.setBoggleTray(dt);
		game.addGuess("see");
		game.addGuess("tees");
		game.addGuess("echos");
		game.addGuess("secret");
		game.addGuess("recites");

		List<String> correct = game.getWordsFound();
		assertEquals("echos", correct.get(0).toLowerCase());
		assertEquals("recites", correct.get(1).toLowerCase());
		assertEquals("secret", correct.get(2).toLowerCase());
		assertEquals("see", correct.get(3).toLowerCase());
		assertEquals("tees", correct.get(4).toLowerCase());
	}

	// the method use to test Failed Get Words Incorrect Are All In
	// UpperLowerCase Are And Ascending Order
	@Test
	public void testFailedGetWordsIncorrectAreAllInUpperLowerCaseAreAndAscendingOrder() {
		char[][] trayA = {

				{ 'E', 'R', 'H', 'I' },

				{ 'T', 'C', 'O', 'Z' },

				{ 'I', 'E', 'S', 'E' },

				{ 'V', 'E', 'V', 'W' } };

		BoggleTray dt = new BoggleTray(trayA);
		Boggle game = new Boggle();
		game.setBoggleTray(dt);
		game.addGuess("Xsee");
		game.addGuess("bTees");
		game.addGuess("zeChos");
		game.addGuess("msecRet");
		game.addGuess("jrecitES");

		List<String> correct = game.getWordsIncorrect();
		assertEquals("btees", correct.get(0));
		assertEquals("jrecites", correct.get(1));
		assertEquals("msecret", correct.get(2));
		assertEquals("xsee", correct.get(3));
		assertEquals("zechos", correct.get(4));
	}

	// the method use to test Failed Get Words Incorrect When Duplicate
	// Incorrect Words Were Guessed
	@Test
	public void testFailedGetWordsIncorrectWhenDuplicateIncorrectWordsWereGuessed() {
		char[][] trayA = {

				{ 'E', 'R', 'H', 'I' },

				{ 'T', 'C', 'O', 'Z' },

				{ 'I', 'E', 'S', 'E' },

				{ 'V', 'E', 'V', 'W' } };

		BoggleTray dt = new BoggleTray(trayA);
		Boggle game = new Boggle();
		game.setBoggleTray(dt);
		game.addGuess("abcdef");
		game.addGuess("xyz");
		game.addGuess("abcdef");
		game.addGuess("xyz");
		game.addGuess("abcdef");
		game.addGuess("xyz");

		List<String> incorrect = game.getWordsIncorrect();
		assertTrue(incorrect.contains("xyz"));
		incorrect.remove("xyz");
		assertFalse(incorrect.contains("xyz"));

		assertTrue(incorrect.contains("abcdef"));
		incorrect.remove("abcdef");
		assertFalse(incorrect.contains("abcdef"));
	}

	// the method use to test Failed Get Words Not Guessed Are All In
	// UpperLowerCase And Ascending Order
	@Test
	public void testFailedGetWordsNotGuessedAreAllInUpperLowerCaseAndAscendingOrder() {
		char[][] trayA = {

				{ 'E', 'R', 'H', 'I' },

				{ 'T', 'C', 'O', 'Z' },

				{ 'I', 'E', 'S', 'E' },

				{ 'V', 'E', 'V', 'W' } };

		BoggleTray dt = new BoggleTray(trayA);
		Boggle game = new Boggle();
		game.setBoggleTray(dt);
		game.addGuess("see");
		game.addGuess("tees");
		game.addGuess("secritive");
		game.addGuess("secret");
		game.addGuess("recites");

		List<String> notFound = game.getWordsNotGuessed();

		assertEquals("[chi, chore, chose, cite, cites, civet, core, cos, echo, "
				+ "echoes, echos, escort, etch, eve, eves, evict, hoe, hoes, "
				+ "hos, hose, ice, ices, itch, ochre, ore, rec, receive, "
				+ "receives, recite, recs, retch, retie, reties, rho, rhos, "
				+ "roe, roes, rose, schizo, score, sec, secretive, sect, set,"
				+ " sew, sore, sort, sortie, tech, tee, tic, tics, tie, ties," + " vet, vetch, vice, vices, vie, vies]",
				notFound.toString());
	}

	// the method use to test Failed Get Words Found Are All In Ascending Order
	// And LowerCase
	@Test
	public void testFailedGetWordsFoundAreAllInAscendingOrderAndLowerCase() {
		char[][] trayA = {

				{ 'E', 'R', 'H', 'I' },

				{ 'T', 'C', 'O', 'Z' },

				{ 'I', 'E', 'S', 'E' },

				{ 'V', 'E', 'V', 'W' } };

		BoggleTray dt = new BoggleTray(trayA);
		Boggle game = new Boggle();
		game.setBoggleTray(dt);
		game.addGuess("see");
		game.addGuess("tees");
		game.addGuess("echos");
		game.addGuess("secret");
		game.addGuess("recites");

		List<String> correct = game.getWordsFound();
		assertEquals("echos", correct.get(0));
		assertEquals("recites", correct.get(1));
		assertEquals("secret", correct.get(2));
		assertEquals("see", correct.get(3));
		assertEquals("tees", correct.get(4));
	}

	private char[][] tray = {

			{ 'M', 'B', 'T', 'R' },

			{ 'E', 'E', 'G', 'A' },

			{ 'Q', 'T', 'N', 'C' },

			{ 'R', 'I', 'O', 'P' } };

	private char[][] tray2 = {

			{ 'H', 'A', 'H', 'I' },

			{ 'V', 'W', 'O', 'S' },

			{ 'E', 'E', 'S', 'E' },

			{ 'T', 'I', 'P', 'W' } };

	private Boggle boggle;
	private Boggle game2;
	private ArrayList<String> usersInput;

	// test add some things.
	@Before
	public void init() {
		BoggleTray dt = new BoggleTray(tray2);
		game2 = new Boggle();
		game2.setBoggleTray(dt);
		usersInput = new ArrayList<String>();

		boggle = new Boggle();
		boggle.setBoggleTray(new BoggleTray(tray));
		ArrayList<String> list = new ArrayList<String>();
		list.add("quit");
		list.add("bee");
		list.add("meeting");
		list.add("tran");
		list.add("ring");
		list.add("not");
		list.add("aconite");
		list.add("not");
		list.add("not");
		list.add("argent");
		list.add("begat");
		list.add("metring");
		list.add("quintet");
		list.add("quirt");
		list.add("rage");
		list.add("taco");
		list.add("rage");
		list.add("taco");
		list.add("rage");
		list.add("taco");
		// mIxed CASE in the board
		list.add("GrANtEe");
		list.add("gRAnITe");
		list.add("trio");

		// mIxed CASE not in the board
		list.add("notHere");
		list.add("notSDdsdasd");

		for (String s : list)
			boggle.addGuess(s);

		// see how sHoW notInTheBoard
		usersInput.add("tip");
		usersInput.add("tips");
		usersInput.add("spit");
		// see how sHoW notInTheBoard
		usersInput.add("see");
		usersInput.add("how");
		usersInput.add("sHoW");
		usersInput.add("spit");
		// tie tee tees shows spite
		usersInput.add("tie");
		usersInput.add("tee");
		usersInput.add("tees");
		usersInput.add("shows");
		usersInput.add("spite");
		// have have have
		usersInput.add("have");
		usersInput.add("have");
		usersInput.add("have");

		// shave shaves Aardvark ZymUrgy
		usersInput.add("shave");
		usersInput.add("shaves");
		usersInput.add("Aardvark");
		usersInput.add("ZymUrgy");

		usersInput.add("");

		for (String s : usersInput)
			game2.addGuess(s);
	}

	// the method use to test Failed Get Score With Game From Spec19
	@Test
	public void testFailedGetScoreWithGameFromSpec19() {
		assertEquals(19, game2.getScore());
	}

	// the method use to test Failed Find Some Words That Should Have Been
	// Correct For First Third of Console Game From Spec
	@Test
	public void testFailedFindSomeWordsThatShouldHaveBeenCorrectForFirstThirdofConsoleGameFromSpec() {
		List<String> found = game2.getWordsFound();
		assertTrue(found.contains("have"));
		assertTrue(found.contains("how"));
		assertTrue(found.contains("see"));
		assertTrue(found.contains("shave"));
	}

	// the method use to test Failed To Find Some Words That Should Have Been
	// Correct For Middle Third of Console Game From Spec
	@Test
	public void testFailedToFindSomeWordsThatShouldHaveBeenCorrectForMiddleThirdofConsoleGameFromSpec() {
		List<String> found = game2.getWordsFound();
		assertTrue(found.contains("shaves"));
		assertTrue(found.contains("show"));
		assertTrue(found.contains("shows"));
		assertTrue(found.contains("spit"));
		assertTrue(found.contains("spite"));
	}

	// the method use to test Failed To Find Some Words That Should Have Been
	// Correct For The Last Third of Console Game From Spec
	@Test
	public void testFailedToFindSomeWordsThatShouldHaveBeenCorrectForTheLastThirdofConsoleGameFromSpec() {
		List<String> found = game2.getWordsFound();
		assertTrue(found.contains("tee"));
		assertTrue(found.contains("tees"));
		assertTrue(found.contains("tie"));
		assertTrue(found.contains("tip"));
		assertTrue(found.contains("tips"));
	}

	// test Whoops Found Word Entered By User That Was Not In The BoggleTray But
	// Was In The Boggle Words of Console Game From Spec
	@Test
	public void testWhoopsFoundWordEnteredByUserThatWasNotInTheBoggleTrayButWasInTheBoggleWordsofConsoleGameFromSpec() {
		List<String> found = game2.getWordsFound();
		assertFalse(found.contains("aardvark"));
		assertFalse(found.contains("zymurgy"));
	}

	// test Whoops Found A Word In The BoggleTray That Was Not In The Boggle
	// Words of Console Game From Spec
	@Test
	public void testWhoopsFoundAWordInTheBoggleTrayThatWasNotInTheBoggleWordsofConsoleGameFromSpec() {
		List<String> found = game2.getWordsFound();
		assertFalse(found.contains("wos"));
		assertFalse(found.contains("hahi"));
	}

	// test Failed To Find Some Words Not Guessed First Part
	@Test
	public void testFailedToFindSomeWordsNotGuessedFirstPart() {
		List<String> notFound = game2.getWordsNotGuessed();
		// awe awes epee eve eves ewe ewes hah haves haw
		// haws his hiss hoe hoes
		assertTrue(notFound.contains("awe"));
		assertTrue(notFound.contains("awes"));
		assertTrue(notFound.contains("epee"));
		assertTrue(notFound.contains("eve"));
		assertTrue(notFound.contains("eves"));
		assertTrue(notFound.contains("ewe"));
		assertTrue(notFound.contains("ewes"));
		assertTrue(notFound.contains("hah"));
		assertTrue(notFound.contains("haves"));
		assertTrue(notFound.contains("haw"));
		assertTrue(notFound.contains("haws"));
		assertTrue(notFound.contains("his"));
		assertTrue(notFound.contains("hiss"));
		assertTrue(notFound.contains("hoe"));
		assertTrue(notFound.contains("hoes"));
	}

	// test Failed To Find Some Other Words Not Guessed Second Part()
	@Test
	public void testFailedToFindSomeOtherWordsNotGuessedSecondPart() {
		List<String> notFound = game2.getWordsNotGuessed();
		// hos hose hoses hows ohs owe owes pee peso pesos pet pew pews pie pies
		// pis pit psi set sew sews shah shoe shoes
		assertTrue(notFound.contains("hos"));
		assertTrue(notFound.contains("hose"));
		assertTrue(notFound.contains("hoses"));
		assertTrue(notFound.contains("hows"));
		assertTrue(notFound.contains("ohs"));
		assertTrue(notFound.contains("owe"));
		assertTrue(notFound.contains("owes"));
		assertTrue(notFound.contains("pee"));
		assertTrue(notFound.contains("peso"));
		assertTrue(notFound.contains("pesos"));
		assertTrue(notFound.contains("pet"));
		assertTrue(notFound.contains("pew"));
		assertTrue(notFound.contains("pie"));
		assertTrue(notFound.contains("pis"));
		assertTrue(notFound.contains("pit"));
		assertTrue(notFound.contains("psi"));
		assertTrue(notFound.contains("set"));
		assertTrue(notFound.contains("sew"));
		assertTrue(notFound.contains("sews"));
		assertTrue(notFound.contains("shah"));
		assertTrue(notFound.contains("shoe"));
		assertTrue(notFound.contains("shoes"));
	}

	// test Failed To Find Some Words Not Guessed Third Part
	@Test
	public void testFailedToFindSomewWordsNotGuessedThirdPart() {
		List<String> notFound = game2.getWordsNotGuessed();
		// sieve sip sit site sos sow sows spew ssh sweep
		// sweet ties tis veep veeps vet wave waves wee weep
		// weeps wees wet who whoa whose woe woes
		// System.out.println(game2.getWordsFound());
		// System.out.println(game2.getWordsNotGuessed());
		assertTrue(notFound.contains("sieve"));
		assertTrue(notFound.contains("sip"));
		assertTrue(notFound.contains("sit"));
		assertTrue(notFound.contains("site"));
		assertTrue(notFound.contains("sos"));
		assertTrue(notFound.contains("sow"));
		assertTrue(notFound.contains("sows"));
		assertTrue(notFound.contains("spew"));
		assertTrue(notFound.contains("ssh"));
		assertTrue(notFound.contains("sweep"));
		assertTrue(notFound.contains("sweet"));
		assertTrue(notFound.contains("ties"));
		assertTrue(notFound.contains("tis"));
		assertTrue(notFound.contains("veep"));
		assertTrue(notFound.contains("veeps"));
		assertTrue(notFound.contains("vet"));
		assertTrue(notFound.contains("wave"));
		assertTrue(notFound.contains("waves"));
		assertTrue(notFound.contains("wee"));
		assertTrue(notFound.contains("weep"));
		assertTrue(notFound.contains("weeps"));
		assertTrue(notFound.contains("wet"));

		assertTrue(notFound.contains("wet"));
		assertTrue(notFound.contains("whoa"));
		assertTrue(notFound.contains("whose"));
		assertTrue(notFound.contains("woes"));

	}

	// test Failed To Find Some Words That Are In The BoggleTray And BoggleWords
	// First Part
	@Test
	public void testFailedToFindSomeWordsThatAreInTheBoggleTrayAndBoggleWordsFirstPart() {
		List<String> shouldBe = new ArrayList<String>();
		shouldBe.add("aconite");
		shouldBe.add("argent");
		shouldBe.add("bee");
		shouldBe.add("begat");

		List<String> found = boggle.getWordsFound();
		for (String s : shouldBe) {
			assertTrue(s + " should have been found in\n " + boggle.getBoggleTrayAsString(), found.contains(s));
		}
	}

	// test Failed To Find Some Words That Are In The BoggleTray And BoggleWords
	// Second Part
	@Test
	public void testFailedToFindSomeWordsThatAreInTheBoggleTrayAndBoggleWordsSecondPart() {
		List<String> shouldBe = new ArrayList<String>();
		shouldBe.add("granite");
		shouldBe.add("grantee");
		shouldBe.add("meeting");
		shouldBe.add("metring");
		shouldBe.add("not");

		for (String s : shouldBe) {
			assertTrue(s + " should have been found in\n " + boggle.getBoggleTrayAsString(),
					boggle.getWordsFound().contains(s));
		}
	}

	// test Failed To Find Some Words That Are In The BoggleTray And BoggleWords
	// Third Part
	@Test
	public void testFailedToFindSomeWordsThatAreInTheBoggleTrayAndBoggleWordsThirdPart() {
		List<String> shouldBe = new ArrayList<String>();
		shouldBe.add("quintet");
		shouldBe.add("quirt");
		shouldBe.add("quit");
		shouldBe.add("rage");
		shouldBe.add("ring");
		shouldBe.add("taco");
		shouldBe.add("trio");

		for (String s : shouldBe) {
			assertTrue(s + " should have been found in\n " + boggle.getBoggleTrayAsString(),
					boggle.getWordsFound().contains(s));
		}
	}

	// test Failed A Get score When It Should Be Fourty Four()
	@Test
	public void testFailedAGetscoreWhenItShouldBeFourtyFour() {
		assertEquals(44, boggle.getScore());
	}

	// test Incorrect Tries When There Are Three
	@Test
	public void testIncorrectTriesWhenThereAreThree() {
		assertTrue(
				"getWordsIncorrect() failed to contain a user input that was NOT in BoggleWords and NOT in this BoggleTray\n"
						+ boggle.getBoggleTrayAsString(),
				boggle.getWordsIncorrect().contains("nothere"));
		assertTrue(
				"getWordsIncorrect() failed to contain a user input that is NOT in BoggleWords but IS in this BoggleTray\n"
						+ boggle.getBoggleTrayAsString(),
				boggle.getWordsIncorrect().contains("tran"));
		assertTrue(
				"getWordsIncorrect() failed to contain a user input that was NOT in BoggleWords and also NOT in this BoggleTray\n"
						+ boggle.getBoggleTrayAsString(),
				boggle.getWordsIncorrect().contains("notsddsdasd"));
	}

	// test Failed Finding Words That Could Have Been Found But Were Not Entered
	// By User
	@Test
	public void testFailedFindingWordsThatCouldHaveBeenFoundButWereNotEnteredByUser() {
		List<String> notGuessed = boggle.getWordsNotGuessed();
		assertTrue(notGuessed.contains("acne"));
		assertTrue(notGuessed.contains("age"));
		assertTrue(notGuessed.contains("antique"));
		assertTrue(notGuessed.contains("teen"));
		assertTrue(notGuessed.contains("queen"));
		assertTrue(notGuessed.contains("riot"));
	}

	// test Failed Because The Same Word Exists In Get words Found And Get Words
	// Not Guessed
	@Test
	public void testFailedBecauseTheSameWordExistsInGetwordsFoundAndGetWordsNotGuessed() {
		List<String> found = boggle.getWordsFound();
		List<String> notGuessed = boggle.getWordsNotGuessed();
		for (int i = 0; i < boggle.getWordsFound().size(); i++) {
			assertFalse(notGuessed.contains(found.get(i)));
		}
	}

	// test Failed To Pass All Assertions In The Given Test Method From Spec
	@Test
	public void testFailedToPassAllAssertionsInTheGivenTestMethodFromSpec() {
		char[][] tray = {

				{ 'E', 'R', 'H', 'I' },

				{ 'T', 'C', 'O', 'Z' },

				{ 'I', 'E', 'S', 'E' },

				{ 'V', 'E', 'V', 'W' } };

		BoggleTray dt = new BoggleTray(tray);
		Boggle game = new Boggle();
		game.setBoggleTray(dt);
		game.addGuess("see");
		game.addGuess("see");
		game.addGuess("see");
		game.addGuess("tEeS");
		game.addGuess("Receives");
		game.addGuess("Sort");
		game.addGuess("cites");
		game.addGuess("seCreTive");
		game.addGuess("NotHere");
		game.addGuess("NotHere");
		game.addGuess("sew");
		assertEquals(28, game.getScore());
		assertEquals("[cites, receives, secretive, see, sew, sort, tees]", game.getWordsFound().toString());
		assertEquals("[nothere]", game.getWordsIncorrect().toString());
	}

}