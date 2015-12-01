package de.tom;

import de.tom.Resident;
import java.util.List;

/**
 * @author Stefan Betermieux
 */
public interface ResidentRepository {

  List<Resident> getResidents();

}