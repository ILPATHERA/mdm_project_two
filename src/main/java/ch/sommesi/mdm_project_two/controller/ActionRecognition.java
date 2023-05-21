package ch.sommesi.mdm_project_two.controller;

import ai.djl.Application;
import ai.djl.ModelException;
import ai.djl.inference.Predictor;
import ai.djl.modality.Classifications;
import ai.djl.modality.cv.Image;
import ai.djl.repository.zoo.Criteria;
import ai.djl.repository.zoo.ZooModel;
import ai.djl.training.util.ProgressBar;
import ai.djl.translate.TranslateException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public final class ActionRecognition {
    //Logger
    public static final Logger logger = LoggerFactory.getLogger(ActionRecognition.class);

    private ActionRecognition() {}

    public static void main(String[] args) throws IOException, ModelException, TranslateException {
        //Classifications classification = ActionRecognition.predict();
        //logger.info("{}", classification);
    }

    public static Classifications predict(Image image) throws IOException, ModelException, TranslateException {
        //Bild klassifizieren
        Criteria<Image, Classifications> criteria =
                Criteria.builder()
                        .optApplication(Application.CV.ACTION_RECOGNITION)
                        .setTypes(Image.class, Classifications.class)
                        .optFilter("backbone", "inceptionv3")
                        .optFilter("dataset", "ucf101")
                        .optEngine("MXNet")
                        .optProgress(new ProgressBar())
                        .build();
        //Criteria loggen
        logger.info("criteria: " + criteria);

        //Model laden   
        try (ZooModel<Image, Classifications> inception = criteria.loadModel()) {
            try (Predictor<Image, Classifications> action = inception.newPredictor()) {
                return action.predict(image);
            }
        }
    }
}
