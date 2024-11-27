package org.example.barber_shop.Mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.example.barber_shop.DTO.File.FileResponseNoOwner;
import org.example.barber_shop.DTO.Service.ServiceResponseNoType;
import org.example.barber_shop.DTO.ServiceType.ServiceTypeRequest;
import org.example.barber_shop.DTO.ServiceType.ServiceTypeResponse;
import org.example.barber_shop.DTO.ServiceType.ServiceTypeResponseNoService;
import org.example.barber_shop.Entity.File;
import org.example.barber_shop.Entity.Service;
import org.example.barber_shop.Entity.ServiceType;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-15T21:29:21+0700",
    comments = "version: 1.6.2, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
)
@Component
public class ServiceTypeMapperImpl implements ServiceTypeMapper {

    @Override
    public ServiceType toEntity(ServiceTypeRequest serviceTypeRequest) {
        if ( serviceTypeRequest == null ) {
            return null;
        }

        ServiceType serviceType = new ServiceType();

        serviceType.setName( serviceTypeRequest.name );

        return serviceType;
    }

    @Override
    public ServiceTypeResponse toDto(ServiceType serviceType) {
        if ( serviceType == null ) {
            return null;
        }

        ServiceTypeResponse serviceTypeResponse = new ServiceTypeResponse();

        if ( serviceType.getId() != null ) {
            serviceTypeResponse.id = serviceType.getId();
        }
        serviceTypeResponse.name = serviceType.getName();
        serviceTypeResponse.services = serviceListToServiceResponseNoTypeList( serviceType.getServices() );
        serviceTypeResponse.createdAt = serviceType.getCreatedAt();
        serviceTypeResponse.updatedAt = serviceType.getUpdatedAt();

        return serviceTypeResponse;
    }

    @Override
    public List<ServiceTypeResponse> toDto(List<ServiceType> serviceTypes) {
        if ( serviceTypes == null ) {
            return null;
        }

        List<ServiceTypeResponse> list = new ArrayList<ServiceTypeResponse>( serviceTypes.size() );
        for ( ServiceType serviceType : serviceTypes ) {
            list.add( toDto( serviceType ) );
        }

        return list;
    }

    @Override
    public ServiceTypeResponseNoService toServiceTypeResponseNoService(ServiceType serviceType) {
        if ( serviceType == null ) {
            return null;
        }

        ServiceTypeResponseNoService serviceTypeResponseNoService = new ServiceTypeResponseNoService();

        if ( serviceType.getId() != null ) {
            serviceTypeResponseNoService.id = serviceType.getId();
        }
        serviceTypeResponseNoService.name = serviceType.getName();
        serviceTypeResponseNoService.createdAt = serviceType.getCreatedAt();
        serviceTypeResponseNoService.updatedAt = serviceType.getUpdatedAt();

        return serviceTypeResponseNoService;
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
