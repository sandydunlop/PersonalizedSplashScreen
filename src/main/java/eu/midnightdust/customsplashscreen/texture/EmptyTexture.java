package eu.midnightdust.customsplashscreen.texture;

import net.minecraft.client.resource.metadata.TextureResourceMetadata;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.ResourceTexture;
import net.minecraft.client.texture.TextureContents;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;

import java.io.IOException;
import java.io.InputStream;

public class EmptyTexture extends ResourceTexture {
    // Empty texture used for hiding the default mojang logo when using other logo styles //

    public EmptyTexture(Identifier location) {
        super(location);
    }

    public TextureContents loadContents(ResourceManager resourceManager) {
        try {
            InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("empty.png");
            TextureContents texture = null;

            if( input != null ) {

                try {
                    texture = new TextureContents(NativeImage.read(input), new TextureResourceMetadata(true, true));
                } finally {
                    input.close();
                }

            }

            return texture;
        } catch (IOException var18) {
            return TextureContents.createMissing();
        }
    }

}
