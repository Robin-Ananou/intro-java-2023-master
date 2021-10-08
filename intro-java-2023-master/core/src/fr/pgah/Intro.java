package fr.pgah;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Intro extends ApplicationAdapter {
  SpriteBatch batch; // variables (SpriteBatch : Type de la variable | batch : nom de la variable)
  Texture[] imgs; // variables (Si le type commence par une majuscule, c'est un type objet | Si le type commence par une minuscule, c'est un type primitif)
  int[] coordonneesX;
  int[] coordonneesY;
  int hauteurFenetre;
  int[] hauteurImgs;
  boolean[] montent;

  @Override
  public void create() { // méthode (create : nom de la méthode)
    batch = new SpriteBatch(); // méthode (= : affectation | new : instanciation)
    imgs = new Texture[2]; // méthode
    imgs[0] = new Texture("sio.jpg"); //0 est l'index du tableau que l'on prend (la case choisie)
    imgs[1] = new Texture("badlogic.jpg"); //1 est l'index du tableau que l'on prend (la case choisie)
    coordonneesX = new int[2];
    coordonneesX[0] = 0; //affectation
    coordonneesX[1] = 100;
    coordonneesY = new int[2];
    coordonneesY[0] = 0;
    coordonneesY[1] = 200;
    hauteurImgs = new int[2];
    hauteurImgs[0] = imgs[0].getHeight();
    hauteurImgs[1] = imgs[1].getHeight();
    hauteurFenetre = Gdx.graphics.getHeight();
    montent = new boolean[2];
    montent[0] = true;
    montent[1] = false;
  }

  @Override
  public void render() {
    reinitialiserBackgroud(); // corps de la méthode
    testerBordures();
    programmeX();
    testerDirection();
    dessin();
  }

  private void dessin() {
    batch.begin(); // corps de la méthode (begin : appel de méthode)
    for (int i = 0; i <= 1; i++) { // Pour 1 allant de 0 à 1 faire :
      batch.draw(imgs[i], coordonneesX[i], coordonneesY[i]); // corps de la méthode
    }
    batch.end(); // corps de la méthode
  }

  private void programmeX() {
    for (int x = 0; x <= 1; x++) {
      coordonneesX[x] = coordonneesX[x] + 1;
    }
  }

  private void testerDirection() {
    for (int a = 0; a <= 1; a++) {
      if (montent[a]) { //test
        coordonneesY[a] = coordonneesY[a] + 1; // incrémentation
      } else {
        coordonneesY[a] = coordonneesY[a] - 1; //décrémentation
      }
    }
  }

  private void testerBordures() {
    // if (Tape la bordure haute)
    for (int z = 0; z <= 1; z++) {
      if(coordonneesY[z] + hauteurImgs[z] == hauteurFenetre) {
        montent[z] = false;
      }
      // if (Tape la bordure basse)
      if(coordonneesY[z] == 0) {
        montent[z] = true;
      }
    }
  }

  private void reinitialiserBackgroud() {
    ScreenUtils.clear(1, 0, 0, 1);
  }
}
