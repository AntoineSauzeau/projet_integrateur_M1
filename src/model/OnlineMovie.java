package model;

public class OnlineMovie extends Movie {

    private String qrCodeLink;

    public String getLink(){
        // TODO : renvoie le lien du QR code
        return "Pas implem";
    }

    public void resetLink(){
        // TODO : reinitialise le lien du film

    }

    public OnlineMovie(){
        this.title = "not set";
        this.category = "not set";
        this.title = "not set";
        this.summary = "not set";
        this.director = "not set";
        this.qrCodeLink = genQrCodeLink();

    }

    private String genQrCodeLink() {
        return "not set";
    }

}
