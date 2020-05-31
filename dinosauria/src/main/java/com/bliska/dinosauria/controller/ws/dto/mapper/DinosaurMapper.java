package com.bliska.dinosauria.controller.ws.dto.mapper;

import com.bliska.dinosauria.controller.ws.dto.DinosaurDTO;
import com.bliska.dinosauria.model.Dinosaur;
import com.bliska.dinosauria.model.FossilSite;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class DinosaurMapper {

    public static final DinosaurMapper INSTANCE = Mappers.getMapper( DinosaurMapper.class );

    @Mapping(source = "dinosaur.clade.name", target = "clade")
    @Mapping(source = "dinosaur.size.height", target = "height")
    @Mapping(source = "dinosaur.size.weight", target = "weight")
    @Mapping(source = "dinosaur.size.length", target = "length")
    @Mapping(source = "dinosaur.fossilSites", target= "fossilSites")
    public abstract DinosaurDTO dinosaurToDinosaurDTO(Dinosaur dinosaur);

    protected String fossilSiteToString(FossilSite fossilSite) {
        return fossilSite.getName();
    }

}
