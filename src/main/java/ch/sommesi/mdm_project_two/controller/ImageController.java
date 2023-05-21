package ch.sommesi.mdm_project_two.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ai.djl.ModelException;
import ai.djl.modality.Classifications;
import ai.djl.modality.cv.Image;
import ai.djl.modality.cv.ImageFactory;
import ai.djl.translate.TranslateException;

import java.io.IOException;

@Controller
public class ImageController {
    //Logger
    private static final Logger logger = LoggerFactory.getLogger(ImageController.class);

    //Bild wird als MultipartFile hochgeladen und muss in ein Image umgewandelt werden
    private Image transformImage(MultipartFile img) {
        try {
            return ImageFactory.getInstance().fromInputStream(img.getInputStream());
        } catch (IOException e) {
            //Logger: Fehlermeldung
            logger.error("Failed to load image");
            throw new RuntimeException(e);
        }
    }

    //Testing
    @GetMapping("/helloWorld")
    @ResponseBody
    public String hello() {
        logger.info("Hello World called");
        return "Hello World!";
    }

    //Startseite anzeigen
    @GetMapping("/model")
    public ModelAndView getModelPage() {
        return new ModelAndView("model");
    }

    /**
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/result")
    public ModelAndView handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException{
        //Bild umwandeln
        Image image = transformImage(file);
        //Logger: Bild hochgeladen
        logger.info("File uploaded: {}", image);
        try {
            //Bild an Model senden und klassifizieren
            Classifications classification = ActionRecognition.predict(image);
            //Logger: Klassifizierung
            logger.info("classifications: {}", classification);
            //Rückmeldung in HTML Seite ausgeben
            ModelAndView mav = new ModelAndView("result");
            mav.addObject("classification", classification);
            return mav;

        } catch (ModelException | TranslateException e) {
            //Logger: Fehlermeldung
            logger.error("Failed to predict", e);
            throw new RuntimeException(e);
        }
    }
}

