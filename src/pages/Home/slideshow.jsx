
import classNames from 'classnames/bind';
import styles from './Home.module.scss';
import { useTranslation } from 'react-i18next';
import '~/utils/language/i18n'; // Import the i18n configuration
const cx = classNames.bind(styles);
function Slideshow({ slides }) {

    const { t, i18n } = useTranslation();
    const changeLanguage = (lng) => {
        i18n.changeLanguage(lng); // Change language
    };
    return (
        <>
            <div className={cx('element')}>
                <img className={cx('img-element')} src={slides} alt="Slide" />
                <h1 className={cx('slide-text')} style={{ color: 'white', textAlign: 'center' }}>
                    {t('The best hair cutting system in Da Nang')}.
                    <p>
                        Choose us because we will help you change your appearance
                    </p>
                </h1>
            </div>
        </>
    );
}

export default Slideshow;
