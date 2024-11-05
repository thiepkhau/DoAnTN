import React, { useState, useRef } from 'react';
import classNames from 'classnames/bind';
import styles from './Home.module.scss';
import { useTranslation } from 'react-i18next';
import '~/utils/language/i18n';
import { Link } from 'react-router-dom';

const cx = classNames.bind(styles);

function Slideshow({ slides }) {
    const { t, i18n } = useTranslation();
    const [isCameraOn, setIsCameraOn] = useState(false);
    const videoRef = useRef(null);

    const changeLanguage = (lng) => {
        i18n.changeLanguage(lng); // Change language
    };

    const handleCameraAccess = async () => {
        try {
            // Yêu cầu quyền truy cập camera
            const stream = await navigator.mediaDevices.getUserMedia({ video: true });
            videoRef.current.srcObject = stream;
            setIsCameraOn(true);
        } catch (err) {
            console.error("Lỗi truy cập camera:", err);
        }
    };

    return (
        <>
            <div className={cx('element')}>
                <img className={cx('img-element')} src={slides} alt="Slide" />
                <h1 className={cx('slide-text')} style={{ color: 'white', textAlign: 'center' }}>
                    {t('The best hair cutting system in Da Nang')}.
                    <p>Choose us because we will help you change your appearance</p>
                    <br />
                    <Link to={'/bookservice'}>
                        <div className={cx('actions')}>
                            <button
                                className={cx('btn-normal')}
                                style={{ backgroundColor: 'darkorange', color: 'white', textAlign: 'center' }}
                            >
                                BOOK NOW
                            </button>
                        </div>
                    </Link>
                    <br />
                    <div className={cx('actions')}>
                        <button
                            className={cx('btn-normal')}
                            style={{ backgroundColor: 'white', color: 'black', textAlign: 'center' }}
                            onClick={handleCameraAccess}
                        >
                            AI Recommend
                        </button>
                    </div>
                </h1>
            </div>

            {/* Phần hiển thị camera */}
            {isCameraOn && (
                <div className={cx('camera-container')}>
                    <video ref={videoRef} autoPlay className={cx('camera-video')} />
                </div>
            )}
        </>
    );
}

export default Slideshow;

