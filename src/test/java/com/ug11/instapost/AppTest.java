package com.ug11.instapost;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    static InstaPost instaPost = new InstaPost();
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    private static Stream<Arguments> provideLogin1GagalTest() {
        return Stream.of(
                Arguments.of("albertusadrian")
        );
    }
    @ParameterizedTest
    @MethodSource("provideLogin1GagalTest")
    public void loginGagal1Test(String input) throws EmailException {
        instaPost.login(input);
        assertEquals("Error: Login gagal! Email yang Anda masukkan tidak valid.",
                outputStreamCaptor.toString().trim());
    }

    private static Stream<Arguments> provideLogin2GagalTest() {
        return Stream.of(
                Arguments.of("albertusadrian@ti.ukdw.ac.id")
        );
    }
    @ParameterizedTest
    @MethodSource("provideLogin2GagalTest")
    public void loginGagal2Test(String input) throws EmailException {
        instaPost.login(input);
        assertEquals("Error: Login gagal! Email Anda tidak terdaftar di Google.",
                outputStreamCaptor.toString().trim());
    }

    private static Stream<Arguments> provideLoginBerhasilTest() {
        return Stream.of(
                Arguments.of("albertusadrian@gmail.com")
        );
    }
    @ParameterizedTest
    @MethodSource("provideLoginBerhasilTest")
    public void loginBerhasilTest(String input) throws EmailException {
        instaPost.login(input);
        assertEquals("Login berhasil!",
                outputStreamCaptor.toString().trim());
    }

    private static Stream<Arguments> providePostingTanpaMentionTest() {
        return Stream.of(
                Arguments.of("Cuaca hari ini sangat baik.")
        );
    }
    @ParameterizedTest
    @MethodSource("providePostingTanpaMentionTest")
    public void PostingTanpaMentionTest(String input) {
        instaPost.post(input);
        String expString = "Caption: Cuaca hari ini sangat baik."+System.lineSeparator()+"Pengguna yang Anda mention: -"+System.lineSeparator()+"Total username yang Anda mention: 0";
        assertEquals(expString,
                outputStreamCaptor.toString().trim());
    }

    private static Stream<Arguments> providePostingDenganMention1Test() {
        return Stream.of(
                Arguments.of("Yuk gaes @nola @joyce makan di sini")
        );
    }
    @ParameterizedTest
    @MethodSource("providePostingDenganMention1Test")
    public void PostingDenganMention1Test(String input) {
        instaPost.post(input);
        String expString = "Caption: Yuk gaes @nola @joyce makan di sini"+System.lineSeparator()+"Pengguna yang Anda mention: @nola, @joyce"+System.lineSeparator()+"Total username yang Anda mention: 2";
        assertEquals(expString,
                outputStreamCaptor.toString().trim());
    }

    private static Stream<Arguments> providePostingDenganMention2Test() {
        return Stream.of(
                Arguments.of("@susi @dea @yossia Yuk kerjain tugas gaes")
        );
    }
    @ParameterizedTest
    @MethodSource("providePostingDenganMention2Test")
    public void PostingDenganMention2Test(String input) {
        instaPost.post(input);
        String expString = "Caption: @susi @dea @yossia Yuk kerjain tugas gaes"+System.lineSeparator()+"Pengguna yang Anda mention: @susi, @dea, @yossia"+System.lineSeparator()+"Total username yang Anda mention: 3";
        assertEquals(expString,
                outputStreamCaptor.toString().trim());
    }

    @Test
    public void PostingDenganMention2Test() {
        instaPost.printInfo();
        String expString = "Username: ALBERTUSADRIAN"+System.lineSeparator()+"Email: albertusadrian@gmail.com"+System.lineSeparator()+"Total Mention: 5";
        assertEquals(expString,
                outputStreamCaptor.toString().trim());
    }
}
