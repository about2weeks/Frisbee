package login;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ChangeImgSize {
	public ImageIcon set(ImageIcon icon) {
		
		Image img = new ImageIcon(icon).getImage();
		Image changeImg = img.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		
		return changeIcon;
	}
}
