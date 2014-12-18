package pl.edu.amu.dji.jms.lab11.review.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.jboss.logging.annotations.ValidIdRange;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.amu.dji.jms.lab11.review.controller.exception.ReviewWithInvalidIsbnException;
import pl.edu.amu.dji.jms.lab11.review.model.Review;
import pl.edu.amu.dji.jms.lab11.review.repository.ReviewRepository;

import java.util.List;



@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewRepository repository;


    @RequestMapping(value = "/{isbn}", method = RequestMethod.GET)
    @JsonView(Review.class)
    public Iterable<Review> getListOfReviews(@PathVariable String isbn){
        return repository.findByIsbnAllIgnoreCase(isbn);
    }


    @RequestMapping(value = "/{isbn}", method = RequestMethod.POST)
    @JsonView(Review.class)
    public Iterable<Review> addReview(@PathVariable String isbn, @RequestBody Review review){
        if(isbn != review.getIsbn())
            throw new ReviewWithInvalidIsbnException();
        repository.save(review);
        return repository.findByIsbnAllIgnoreCase(isbn);
    }
}
