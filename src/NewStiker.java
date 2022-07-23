import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class NewStiker {

    public void cria(InputStream inputImage, String nomeArquivo) throws Exception {

        // leitura da imagem
        // BufferedImage imagemOriginal = ImageIO.read(new
        // File("entrada/filme-maior.jpg"));
        // InputStream inputImage = new URL(
        // "https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@.jpg")
        // .openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputImage);
        // cria nova imagem em memória com transparênciae com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage newImage = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original pra nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // configurar a fonte
        var font = new Font(Font.SANS_SERIF, Font.BOLD, 130);
        graphics.setFont(font);
        graphics.setColor(Color.YELLOW);

        // escrever uma frase na nova imagem
        graphics.drawString("VAMO DE FILMÃO?", 100, novaAltura - 60);
        // System.out.println(largura);

        // escrever a nova imagem em um arquivo
        if (!new File("saida").exists()) {
            new File("saida").mkdir();
        }
        ImageIO.write(newImage, "png", new File("saida/" + nomeArquivo));

    }
}
