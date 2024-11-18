package org.example.barber_shop.Mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.example.barber_shop.DTO.Combo.ComboResponse;
import org.example.barber_shop.DTO.File.FileResponseNoOwner;
import org.example.barber_shop.DTO.Service.ServiceResponseNoType;
import org.example.barber_shop.Entity.Combo;
import org.example.barber_shop.Entity.File;
import org.example.barber_shop.Entity.Service;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-15T21:29:21+0700",
    comments = "version: 1.6.2, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
)
@Component
public class ComboMapperImpl implements ComboMapper {

    @Override
    public ComboResponse toResponse(Combo combo) {
        if ( combo == null ) {
            return null;
        }

        ComboResponse comboResponse = new ComboResponse();

        if ( combo.getId() != null ) {
            comboResponse.id = combo.getId();
        }
        comboResponse.name = combo.getName();
        comboResponse.description = combo.getDescription();
        comboResponse.price = combo.getPrice();
        comboResponse.estimateTime = combo.getEstimateTime();
        comboResponse.images = fileListToFileResponseNoOwnerList( combo.getImages() );
        comboResponse.services = serviceListToServiceResponseNoTypeList( combo.getServices() );
        comboResponse.createdAt = combo.getCreatedAt();
        comboResponse.updatedAt = combo.getUpdatedAt();

        return comboResponse;
    }

    @Override
    public List<ComboResponse> toResponses(List<Combo> combos) {
        if ( combos == null ) {
            return null;
        }

        List<ComboResponse> list = new ArrayList<ComboResponse>( combos.size() );
        for ( Combo combo : combos ) {
            list.add( toResponse( combo ) );
        }

        return list;
    }

    protected FileResponseNoOwner fileToFileResponseNoOwner(File file) {
        if ( file == null ) {
            return null;
        }

        FileResponseNoOwner fileResponseNoOwner = new FileResponseNoOwner();

        if ( file.getId() != null ) {
            fileResponseNoOwner.id = file.getId().intValue();
        }
        fileResponseNoOwner.name = file.getName();
        fileResponseNoOwner.url = file.getUrl();
        fileResponseNoOwner.thumbUrl = file.getThumbUrl();
        fileResponseNoOwner.mediumUrl = file.getMediumUrl();
        fileResponseNoOwner.createdAt = file.getCreatedAt();
        fileResponseNoOwner.updatedAt = file.getUpdatedAt();

        return fileResponseNoOwner;
    }

    protected List<FileResponseNoOwner> fileListToFileResponseNoOwnerList(List<File> list) {
        if ( list == null ) {
            return null;
        }

        List<FileResponseNoOwner> list1 = new ArrayList<FileResponseNoOwner>( list.size() );
        for ( File file : list ) {
            list1.add( fileToFileResponseNoOwner( file ) );
        }

        return list1;
    }

    protected ServiceResponseNoType serviceToServiceResponseNoType(Service service) {
        if ( service == null ) {
            return null;
        }

        ServiceResponseNoType serviceResponseNoType = new ServiceResponseNoType();

        if ( service.getId() != null ) {
            serviceResponseNoType.id = service.getId();
        }
        serviceResponseNoType.name = service.getName();
        serviceResponseNoType.description = service.getDescription();
        serviceResponseNoType.price = service.getPrice();
        serviceResponseNoType.estimateTime = service.getEstimateTime();
        serviceResponseNoType.images = fileListToFileResponseNoOwnerList( service.getImages() );
        serviceResponseNoType.createdAt = service.getCreatedAt();
        serviceResponseNoType.updatedAt = service.getUpdatedAt();

        return serviceResponseNoType;
    }

    protected List<ServiceResponseNoType> serviceListToServiceResponseNoTypeList(List<Service> list) {
        if ( list == null ) {
            return null;
        }

        List<ServiceResponseNoType> list1 = new ArrayList<ServiceResponseNoType>( list.size() );
        for ( Service service : list ) {
            list1.add( serviceToServiceResponseNoType( service ) );
        }

        return list1;
    }
}
