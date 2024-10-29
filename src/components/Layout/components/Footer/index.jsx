import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faFacebook, faInstagram } from '@fortawesome/free-brands-svg-icons';
import classNames from 'classnames/bind';
import LocationOnIcon from '@mui/icons-material/LocationOn';
import CallIcon from '@mui/icons-material/Call';
import MailOutlineIcon from '@mui/icons-material/MailOutline';
import PhoneIcon from '@mui/icons-material/Phone';
import styles from './Footer.module.scss';
const cx = classNames.bind(styles);
function Footer() {
    const address = [
        {
            location: ' Số 1 Lương Yên, Q.Hai Bà Trưng, Hà Nội',
            phone: '0934 323 882',
        },
        {
            location: ' Số 1 Lương Yên, Q.Hai Bà Trưng, Hà Nội',
            phone: '0934 323 882',
        },
        {
            location: ' Số 1 Lương Yên, Q.Hai Bà Trưng, Hà Nội',
            phone: '0934 323 882',
        },
        {
            location: ' Số 1 Lương Yên, Q.Hai Bà Trưng, Hà Nội',
            phone: '0934 323 882',
        },
        {
            location: ' Số 1 Lương Yên, Q.Hai Bà Trưng, Hà Nội',
            phone: '0934 323 882',
        },
    ];
    return (
        <>
            <footer className={cx('footer-element')}>
                <div>
                    <h3>Địa chỉ</h3>
                    <ul>
                        {address.map((item, index) => (
                            <li key={index}>
                                <span>
                                <LocationOnIcon className="contact-icon" />
                                    {item.location}
                                </span>
                                <span>
                                <CallIcon className="contact-icon" />
                                    <a href={`tel: ${item.phone}`}>{item.phone}</a>
                                </span>
                            </li>
                        ))}
                    </ul>
                </div>
                <div>
                    <h3>giờ mở cửa </h3>
                    <p>
                        Từ 8:00 - 22:00 tất cả các ngày trong tuần (trừ ngày lễ, ngày Tết). Vui lòng đến sớm 15 phút
                        trước thời gian đã đặt lịch.
                    </p>
                </div>
                <div>
                    <h3>LIÊN KẾT VỚI CHÚNG TÔI </h3>
                    <div>
                        <a href="https://facebook.com" className="linked-icon">
                            <FontAwesomeIcon icon={faFacebook} size="xl"></FontAwesomeIcon>
                        </a>
                        <a href="https://facebook.com" className="linked-icon">
                            <FontAwesomeIcon icon={faInstagram} size="xl"></FontAwesomeIcon>
                        </a>
                    </div>
                </div>
                <div>
                    <h3>LIÊN lạc </h3>
                    <div>
                        <MailOutlineIcon className="contact-icon" />
                            Phone: <span>13135123</span>
                        <br></br>
                        <PhoneIcon className="contact-icon" />
                            Mail: <span>anhluong@gmail.com</span>
                    </div>
                </div>
            </footer>
            <div className={cx('footer-bottom')}>
                <div className={cx('footer-bottom-element')}>@2023 All Rights reserved</div>
                <div className={cx('footer-bottom-element')}>Powered by Company</div>
            </div>
        </>
    );
}

export default Footer;
