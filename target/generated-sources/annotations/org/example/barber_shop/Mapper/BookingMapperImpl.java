package org.example.barber_shop.Mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.example.barber_shop.DTO.Booking.BookingResponseAdmin;
import org.example.barber_shop.DTO.Booking.BookingResponseNoStaff;
import org.example.barber_shop.DTO.Booking.BookingResponseNoUser;
import org.example.barber_shop.DTO.Booking.WorkScheduleResponse;
import org.example.barber_shop.DTO.BookingDetail.BookingDetailResponse;
import org.example.barber_shop.DTO.Combo.ComboResponse;
import org.example.barber_shop.DTO.File.FileResponseNoOwner;
import org.example.barber_shop.DTO.Service.ServiceResponseNoType;
import org.example.barber_shop.DTO.User.UserResponse;
import org.example.barber_shop.DTO.User.UserResponseNoFile;
import org.example.barber_shop.Entity.Booking;
import org.example.barber_shop.Entity.BookingDetail;
import org.example.barber_shop.Entity.Combo;
import org.example.barber_shop.Entity.File;
import org.example.barber_shop.Entity.Service;
import org.example.barber_shop.Entity.User;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-22T09:35:49+0700",
    comments = "version: 1.6.2, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
)
@Component
public class BookingMapperImpl implements BookingMapper {

    @Override
    public BookingResponseNoUser toResponse(Booking booking) {
        if ( booking == null ) {
            return null;
        }

        BookingResponseNoUser bookingResponseNoUser = new BookingResponseNoUser();

        if ( booking.getId() != null ) {
            bookingResponseNoUser.id = booking.getId();
        }
        bookingResponseNoUser.status = booking.getStatus();
        bookingResponseNoUser.note = booking.getNote();
        bookingResponseNoUser.staff = userToUserResponse( booking.getStaff() );
        bookingResponseNoUser.startTime = booking.getStartTime();
        bookingResponseNoUser.endTime = booking.getEndTime();
        bookingResponseNoUser.createdAt = booking.getCreatedAt();
        bookingResponseNoUser.updatedAt = booking.getUpdatedAt();
        bookingResponseNoUser.bookingDetails = bookingDetailListToBookingDetailResponseList( booking.getBookingDetails() );

        return bookingResponseNoUser;
    }

    @Override
    public List<BookingResponseNoUser> toResponses(List<Booking> bookings) {
        if ( bookings == null ) {
            return null;
        }

        List<BookingResponseNoUser> list = new ArrayList<BookingResponseNoUser>( bookings.size() );
        for ( Booking booking : bookings ) {
            list.add( toResponse( booking ) );
        }

        return list;
    }

    @Override
    public List<WorkScheduleResponse> toWorkScheduleResponses(List<Booking> bookings) {
        if ( bookings == null ) {
            return null;
        }

        List<WorkScheduleResponse> list = new ArrayList<WorkScheduleResponse>( bookings.size() );
        for ( Booking booking : bookings ) {
            list.add( bookingToWorkScheduleResponse( booking ) );
        }

        return list;
    }

    @Override
    public List<BookingResponseNoStaff> toResponseNoStaff(List<Booking> bookings) {
        if ( bookings == null ) {
            return null;
        }

        List<BookingResponseNoStaff> list = new ArrayList<BookingResponseNoStaff>( bookings.size() );
        for ( Booking booking : bookings ) {
            list.add( bookingToBookingResponseNoStaff( booking ) );
        }

        return list;
    }

    @Override
    public List<BookingResponseAdmin> toResponseAdmin(List<Booking> bookings) {
        if ( bookings == null ) {
            return null;
        }

        List<BookingResponseAdmin> list = new ArrayList<BookingResponseAdmin>( bookings.size() );
        for ( Booking booking : bookings ) {
            list.add( bookingToBookingResponseAdmin( booking ) );
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

    protected UserResponse userToUserResponse(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponse userResponse = new UserResponse();

        if ( user.getId() != null ) {
            userResponse.id = user.getId().intValue();
        }
        userResponse.name = user.getName();
        userResponse.email = user.getEmail();
        userResponse.phone = user.getPhone();
        userResponse.dob = user.getDob();
        userResponse.avatar = fileToFileResponseNoOwner( user.getAvatar() );
        userResponse.verified = user.isVerified();
        userResponse.blocked = user.isBlocked();
        userResponse.role = user.getRole();
        userResponse.createdAt = user.getCreatedAt();
        userResponse.updatedAt = user.getUpdatedAt();

        return userResponse;
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

    protected ComboResponse comboToComboResponse(Combo combo) {
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

    protected BookingDetailResponse bookingDetailToBookingDetailResponse(BookingDetail bookingDetail) {
        if ( bookingDetail == null ) {
            return null;
        }

        BookingDetailResponse bookingDetailResponse = new BookingDetailResponse();

        if ( bookingDetail.getId() != null ) {
            bookingDetailResponse.id = bookingDetail.getId();
        }
        bookingDetailResponse.service = serviceToServiceResponseNoType( bookingDetail.getService() );
        bookingDetailResponse.combo = comboToComboResponse( bookingDetail.getCombo() );
        bookingDetailResponse.createdAt = bookingDetail.getCreatedAt();
        bookingDetailResponse.updatedAt = bookingDetail.getUpdatedAt();

        return bookingDetailResponse;
    }

    protected List<BookingDetailResponse> bookingDetailListToBookingDetailResponseList(List<BookingDetail> list) {
        if ( list == null ) {
            return null;
        }

        List<BookingDetailResponse> list1 = new ArrayList<BookingDetailResponse>( list.size() );
        for ( BookingDetail bookingDetail : list ) {
            list1.add( bookingDetailToBookingDetailResponse( bookingDetail ) );
        }

        return list1;
    }

    protected WorkScheduleResponse bookingToWorkScheduleResponse(Booking booking) {
        if ( booking == null ) {
            return null;
        }

        WorkScheduleResponse workScheduleResponse = new WorkScheduleResponse();

        if ( booking.getId() != null ) {
            workScheduleResponse.id = booking.getId();
        }
        workScheduleResponse.startTime = booking.getStartTime();
        workScheduleResponse.endTime = booking.getEndTime();

        return workScheduleResponse;
    }

    protected BookingResponseNoStaff bookingToBookingResponseNoStaff(Booking booking) {
        if ( booking == null ) {
            return null;
        }

        BookingResponseNoStaff bookingResponseNoStaff = new BookingResponseNoStaff();

        if ( booking.getId() != null ) {
            bookingResponseNoStaff.id = booking.getId();
        }
        bookingResponseNoStaff.status = booking.getStatus();
        bookingResponseNoStaff.note = booking.getNote();
        bookingResponseNoStaff.customer = userToUserResponse( booking.getCustomer() );
        bookingResponseNoStaff.startTime = booking.getStartTime();
        bookingResponseNoStaff.endTime = booking.getEndTime();
        bookingResponseNoStaff.createdAt = booking.getCreatedAt();
        bookingResponseNoStaff.updatedAt = booking.getUpdatedAt();
        bookingResponseNoStaff.bookingDetails = bookingDetailListToBookingDetailResponseList( booking.getBookingDetails() );

        return bookingResponseNoStaff;
    }

    protected UserResponseNoFile userToUserResponseNoFile(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponseNoFile userResponseNoFile = new UserResponseNoFile();

        if ( user.getId() != null ) {
            userResponseNoFile.id = user.getId().intValue();
        }
        userResponseNoFile.name = user.getName();
        userResponseNoFile.email = user.getEmail();
        userResponseNoFile.phone = user.getPhone();
        userResponseNoFile.dob = user.getDob();
        userResponseNoFile.verified = user.isVerified();
        userResponseNoFile.blocked = user.isBlocked();
        userResponseNoFile.role = user.getRole();
        userResponseNoFile.createdAt = user.getCreatedAt();
        userResponseNoFile.updatedAt = user.getUpdatedAt();

        return userResponseNoFile;
    }

    protected BookingResponseAdmin bookingToBookingResponseAdmin(Booking booking) {
        if ( booking == null ) {
            return null;
        }

        BookingResponseAdmin bookingResponseAdmin = new BookingResponseAdmin();

        if ( booking.getId() != null ) {
            bookingResponseAdmin.id = booking.getId();
        }
        bookingResponseAdmin.status = booking.getStatus();
        bookingResponseAdmin.note = booking.getNote();
        bookingResponseAdmin.staff = userToUserResponseNoFile( booking.getStaff() );
        bookingResponseAdmin.customer = userToUserResponseNoFile( booking.getCustomer() );
        bookingResponseAdmin.startTime = booking.getStartTime();
        bookingResponseAdmin.endTime = booking.getEndTime();
        bookingResponseAdmin.createdAt = booking.getCreatedAt();
        bookingResponseAdmin.updatedAt = booking.getUpdatedAt();
        bookingResponseAdmin.bookingDetails = bookingDetailListToBookingDetailResponseList( booking.getBookingDetails() );

        return bookingResponseAdmin;
    }
}
