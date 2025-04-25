package aims.media.sort;
import java.util.Comparator;
import aims.media.Media;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        return Comparator.comparing(Media::getTitle)
                .thenComparing(Media::getCost)
                .compare(m1, m2);
    }
    
}
    