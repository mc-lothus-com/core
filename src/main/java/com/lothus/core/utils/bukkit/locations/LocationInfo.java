package com.lothus.core.utils.bukkit.locations;

import com.lothus.core.utils.bukkit.locations.type.LocationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;

@Getter @Setter
@AllArgsConstructor
public class LocationInfo {

    private Location location;
    private LocationType locationType;

}
