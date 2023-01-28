package com.ug11.instapost;

public class App 
{
    public static void main( String[] args ) throws EmailException {
        InstaPost instaPost = new InstaPost();
        System.out.println("----------Skenario 1: Login Gagal----------");
        instaPost.login("albertusadrian");
        instaPost.login("albertusadrian@ti.ukdw.ac.id");
        System.out.println("\n----------Skenario 2: Login Berhasil----------");
        instaPost.login("albertusadrian@gmail.com");
        System.out.println("\n----------Skenario 3: Posting Tanpa Mention----------");
        instaPost.post("Cuaca hari ini sangat baik.");
        System.out.println("\n----------Skenario 4: Posting dengan Mention #1----------");
        instaPost.post("Yuk gaes @nola @joyce makan di sini");
        System.out.println("\n----------Skenario 5: Posting dengan Mention #2----------");
        instaPost.post("@susi @dea @yossia Yuk kerjain tugas gaes");
        System.out.println("\n----------Skenario Final: Print Informasi Akun----------");
        instaPost.printInfo();
    }
}
