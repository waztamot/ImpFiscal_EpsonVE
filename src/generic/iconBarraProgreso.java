/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package generic;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 * Clase que controla la barra de progeso e iconos
 * @author Ing. Javier Alarcon
 */
public class iconBarraProgreso {
    private Image       defImageValue, infoImageValue, successImageValue,
            errorImageValue, warningImageValue;
    private ImageIcon   defImage, infoImage, successImage,
            errorImage, warningImage;

    public iconBarraProgreso() {
        //  Definicion Image
        this.defImageValue  = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("recurso/Iconos/tunal_icon.png"));
        this.infoImageValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("recurso/Iconos/Knob_Blue16.png"));
        this.successImageValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("recurso/Iconos/Knob_Green16.png"));
        this.errorImageValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("recurso/Iconos/Knob_Red16.png"));
        this.warningImageValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("recurso/Iconos/Knob_Orange16.png"));
        
        //  Definicion ImageIcon
        this.defImage       = new ImageIcon(this.defImageValue);
        this.infoImage      = new ImageIcon(this.infoImageValue);
        this.successImage   = new ImageIcon(this.successImageValue);
        this.errorImage     = new ImageIcon(this.errorImageValue);
        this.warningImage   = new ImageIcon(this.warningImageValue);
    }

    public Image getDefImageValue() {
        return defImageValue;
    }

    public void setDefImageValue(Image defImageValue) {
        this.defImageValue = defImageValue;
    }

    public Image getInfoImageValue() {
        return infoImageValue;
    }

    public void setInfoImageValue(Image infoImageValue) {
        this.infoImageValue = infoImageValue;
    }

    public Image getSuccessImageValue() {
        return successImageValue;
    }

    public void setSuccessImageValue(Image successImageValue) {
        this.successImageValue = successImageValue;
    }

    public Image getErrorImageValue() {
        return errorImageValue;
    }

    public void setErrorImageValue(Image errorImageValue) {
        this.errorImageValue = errorImageValue;
    }

    public Image getWarningImageValue() {
        return warningImageValue;
    }

    public void setWarningImageValue(Image warningImageValue) {
        this.warningImageValue = warningImageValue;
    }

    public ImageIcon getDefImage() {
        return defImage;
    }

    public void setDefImage(ImageIcon defImage) {
        this.defImage = defImage;
    }

    public ImageIcon getInfoImage() {
        return infoImage;
    }

    public void setInfoImage(ImageIcon infoImage) {
        this.infoImage = infoImage;
    }

    public ImageIcon getSuccessImage() {
        return successImage;
    }

    public void setSuccessImage(ImageIcon successImage) {
        this.successImage = successImage;
    }

    public ImageIcon getErrorImage() {
        return errorImage;
    }

    public void setErrorImage(ImageIcon errorImage) {
        this.errorImage = errorImage;
    }

    public ImageIcon getWarningImage() {
        return warningImage;
    }

    public void setWarningImage(ImageIcon warningImage) {
        this.warningImage = warningImage;
    }
    
}
