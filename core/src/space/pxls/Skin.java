package space.pxls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Skin extends com.badlogic.gdx.scenes.scene2d.ui.Skin {
    public Skin() {
        addDrawable("pixel", "pixel.png");
        addDrawable("palette", "palette.png");
        addDrawable("cog", "cog_black.png");
        addDrawable("menu", "menu.png");
        addDrawable("logout", "logout_black.png");
        addDrawable("times", "times.png");
        addDrawable("checked", "checked.png");
        addDrawable("unchecked", "unchecked.png");
        addDrawable("user", "user.png");

        addPatch("light-patch", "light.9.png", 13, 14, 14, 14);
        addPatch("white-patch", "white.9.png", 5, 5, 5, 5);
        addPatch("rounded.topLeft", "rounded.topLeft.9.png", 5,5,5,5);
        addPatch("rounded.topRight", "rounded.topRight.9.png", 5,5,5,5);

        add("default-horizontal", new Slider.SliderStyle(new TextureRegionDrawable(new TextureRegion(new Texture("slider.png"))), new TextureRegionDrawable(new TextureRegion(new Texture("slider-knob.png")))));

        add("default", new Button.ButtonStyle(new NinePatchDrawable(new NinePatch(new Texture("btn-up.9.png"), 5, 5, 5, 5)), new NinePatchDrawable(new NinePatch(new Texture("btn-down.9.png"), 5, 5, 5, 5)), new NinePatchDrawable(new NinePatch(new Texture("btn-up.9.png"), 5, 5, 5, 5))));

        BitmapFont font = new BitmapFont(Gdx.files.internal("font.fnt"));
        font.setUseIntegerPositions(false);
        for (TextureRegion textureRegion : font.getRegions()) {
            textureRegion.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        }
        add("default", font);
        add("default", new Label.LabelStyle(font, Color.BLACK));

        add("default", new TextButton.TextButtonStyle(new NinePatchDrawable(new NinePatch(new Texture("btn-up.9.png"), 7,7,7,7)), new NinePatchDrawable(new NinePatch(new Texture("btn-down.9.png"), 7, 7, 7, 7)), new NinePatchDrawable(new NinePatch(new Texture("btn-up.9.png"), 7,7,7,7)), font));
        add("red", new TextButton.TextButtonStyle(new NinePatchDrawable(new NinePatch(new Texture("btn-up.red.9.png"), 7,7,7,7)), new NinePatchDrawable(new NinePatch(new Texture("btn-down.red.9.png"), 7, 7, 7, 7)), new NinePatchDrawable(new NinePatch(new Texture("btn-up.red.9.png"), 7,7,7,7)), font));
        add("blue", new TextButton.TextButtonStyle(new NinePatchDrawable(new NinePatch(new Texture("btn-up.blue.9.png"), 7,7,7,7)), new NinePatchDrawable(new NinePatch(new Texture("btn-down.blue.9.png"), 7, 7, 7, 7)), new NinePatchDrawable(new NinePatch(new Texture("btn-up.blue.9.png"), 7,7,7,7)), font));

        TintedDrawable td = new TintedDrawable();
        td.color = new Color(1, 1, 1, 0.7f);
        add("background", newDrawable("pixel", 1, 1, 1, 0.85f), Drawable.class);
    }

    private void addDrawable(String name, String textureLoc) {
        add(name, new TextureRegionDrawable(new TextureRegion(new Texture(textureLoc))), Drawable.class);
    }

    private void addPatch(String name, String textureLoc, int left, int right, int top, int bottom) {
        add(name, new NinePatch(new Texture(textureLoc), left, right, top, bottom));
    }
}
