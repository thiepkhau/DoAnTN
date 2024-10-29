import React from 'react';
import { useState, useEffect } from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faBars, faTimes, faSearch } from '@fortawesome/free-solid-svg-icons';
import classNames from 'classnames/bind';
import styles from './Header.module.scss';
import logo from '~/assets/images/logo2.png';
import { Link, useLocation } from 'react-router-dom';
import { logoutSuccess } from '~/utils/store/authSlice';
import { useDispatch, useSelector } from 'react-redux';
import isAdmin from '~/utils/jwt';
import { Avatar, Badge } from '@mui/material';
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import NotificationsActiveIcon from '@mui/icons-material/NotificationsActive';
import Tippy from '@tippyjs/react/headless';
import 'tippy.js/dist/tippy.css';
import { useTranslation } from 'react-i18next';
import '~/utils/language/i18n'; // Import the i18n configuration
const cx = classNames.bind(styles);
function Header() {
    const [status, setStatus] = useState(false);
    const [isFixed, setIsFixed] = useState(false);
    const location = useLocation();
    const currentURL = location.pathname;
    const dispatch = useDispatch();
    const { t, i18n } = useTranslation();


    const user = useSelector((state) => state.auth.login?.currenUser);
    useEffect(() => {
        const handleScroll = () => {
            const headerPosition = window.scrollY;

            if (headerPosition > 0 && !isFixed) {
                setIsFixed(true);
            } else if (headerPosition === 0 && isFixed) {
                setIsFixed(false);
            }
        };

        window.addEventListener('scroll', handleScroll);

        return () => {
            window.removeEventListener('scroll', handleScroll);
        };
    }, [isFixed]);

    const handleLogout = () => {
        dispatch(logoutSuccess());
    };

    const changeLanguage = (lng) => {
        i18n.changeLanguage(lng); // Change language
    };
    return (
        <header className={cx('wrapper', isFixed ? 'fixed-header' : '')}>
            <img src='https://s3-alpha-sig.figma.com/img/79d3/7295/d43a4498fd762cce7119da912ded93a6?Expires=1730678400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=YZBNP7pSMnCYp-PS11eAn5oSQoaq2URJEwbip6b99kzjeAjDi1j2tUTmak5pdOAY4FIi1BUOZ33c0BzsBt1ga4IZtT30xGqOYzaxGshl2hrXZXA3o10bOlmvtpN4kZ8WMTnTZ~uFmLyR9HIn-AfJZ4OeinalncBBfoAo-Q1cJnpv4TskDZRnPkBHI0ZWLQtpIZlbqRaHRWn6iGQZWj0rUBJE1aKAAWjQhBQznz8hNd3Vp4TN6cl8xX6lxcSw8syqRGKv4XsUelKLuV6zWCNlmk819QrZ4g4oZmiO6wAZDIeq0lVCFVOsqi-ljmFYsSbB6Evkv~ZgB~iVNmiXpEGUxQ__' alt="logo" className={cx('logo')} />
            <div className={cx('inner')} style={status ? { right: '0px' } : {}}>
                <ul className={cx('ul-element')}>
                    <Link to={'/'}>
                        <li className={cx('element', currentURL === '/' && 'header-active')}>{t('Home')}</li>
                    </Link>
                    <Link to={'/'}>
                        <li className={cx('element')}>{t('About barber')}</li>
                    </Link>
                    {/*<Link to={'/service'}>*/}
                    {/*    <li className={cx('element', currentURL === '/service' && 'header-active')}>dịch vụ</li>*/}
                    {/*</Link>*/}
                    <Link to={'/serviceExample'}>
                        <li className={cx('element', currentURL === '/serviceExample' && 'header-active')}>Service</li>
                    </Link>
                    <li className={cx('element')}>{t('Contact')}</li>
                    <select id="language-select" onChange={(e) => changeLanguage(e.target.value)}>
                        <option value="en">English</option>
                        <option value="vi">Tiếng Việt</option>
                        <option value="kor">Tiếng Hàn</option>
                    </select>
                    {user && isAdmin(user.accessToken) && (
                        <Link to={`/dashboard`}>
                            <li className={cx('element')}>Admin</li>
                        </Link>
                    )}

                    {/* {user && (
                        <li className={cx('element')} onClick={handleLogout}>
                            đăng xuất
                        </li>
                    )} */}
                </ul>
                {!user ? (
                    <Link to={'/login'}>
                        <div className={cx('actions')}>
                            <button className={cx('btn-normal')}>đăng nhập</button>
                        </div>
                    </Link>
                ) : (
                    <div className={cx('actions', 'actions-mobile')}>
                        <div className={cx('search')}>
                            <Tippy
                                hideOnClick={true}
                                trigger="click"
                                placement="bottom"
                                interactive
                                render={(attrs) => (
                                    <>
                                        <input placeholder="Tìm kiếm dịch vụ" />
                                        <button className={cx('search-btn')}>
                                            <FontAwesomeIcon icon={faSearch} />
                                        </button>
                                    </>
                                )}
                            >
                                <button className={cx('search-btn')}>
                                    <FontAwesomeIcon icon={faSearch} />
                                </button>
                            </Tippy>
                        </div>
                        <Badge
                            badgeContent={4}
                            color="error"
                            sx={{ '& .MuiBadge-badge': { fontSize: 15, height: 15, minWidth: 15 } }}
                        >
                            <Link to={'/cart'}>
                                <ShoppingCartIcon color="action" sx={{ fontSize: 35, cursor: 'pointer' }} />
                            </Link>
                        </Badge>
                        <Badge
                            badgeContent={5}
                            color="error"
                            sx={{ '& .MuiBadge-badge': { fontSize: 15, height: 15, minWidth: 15 } }}
                        >
                            <Link to={'/notification'}>
                                <NotificationsActiveIcon color="action" sx={{ fontSize: 35, cursor: 'pointer' }} />
                            </Link>
                        </Badge>
                        <Tippy
                            //  content="Tài khoản "
                            hideOnClick={true}
                            trigger="click"
                            placement="bottom"
                            interactive
                            render={(attrs) => (
                                <div className={cx('box_tippy')} tabIndex="-1" {...attrs}>
                                    <ul>
                                        <Link to={'/profile'}>
                                            <li>Hồ sơ</li>
                                        </Link>
                                        <li>Lịch sử</li>
                                        <li onClick={handleLogout}>Đăng xuất</li>
                                    </ul>
                                </div>
                            )}
                        >
                            <Avatar alt="avatar" src={user.img} />
                        </Tippy>
                    </div>
                )}
            </div>
            <div className={cx('mobile')}>
                <div>
                    {user && (
                        <div className={cx('actions')}>
                            <div className={cx('search')}>
                                <Tippy
                                    hideOnClick={true}
                                    trigger="click"
                                    placement="bottom"
                                    interactive
                                    render={(attrs) => <input placeholder="Tìm kiếm dịch vụ" />}
                                >
                                    <button className={cx('search-btn')}>
                                        <FontAwesomeIcon icon={faSearch} />
                                    </button>
                                </Tippy>
                            </div>
                            <Badge
                                badgeContent={4}
                                color="error"
                                sx={{ '& .MuiBadge-badge': { fontSize: 15, height: 15, minWidth: 15 } }}
                            >
                                <Link to={'/cart'}>
                                    <ShoppingCartIcon color="action" sx={{ fontSize: 35, cursor: 'pointer' }} />
                                </Link>
                            </Badge>
                            <Badge
                                badgeContent={5}
                                color="error"
                                sx={{ '& .MuiBadge-badge': { fontSize: 15, height: 15, minWidth: 15 } }}
                            >
                                <Link to={'/notification'}>
                                    <NotificationsActiveIcon color="action" sx={{ fontSize: 35, cursor: 'pointer' }} />
                                </Link>
                            </Badge>
                            <Tippy
                                //  content="Tài khoản "
                                hideOnClick={true}
                                trigger="click"
                                placement="bottom"
                                interactive
                                render={(attrs) => (
                                    <div className={cx('box_tippy')} tabIndex="-1" {...attrs}>
                                        <ul>
                                            <li>Hồ sơ</li>
                                            <li>Lịch sử</li>
                                            <li onClick={handleLogout}>Đăng xuất</li>
                                        </ul>
                                    </div>
                                )}
                            >
                                <Avatar alt="avatar" src={user.img} />
                            </Tippy>
                        </div>
                    )}
                </div>
                <div onClick={() => setStatus(!status)}>
                    <FontAwesomeIcon icon={status ? faTimes : faBars} size="2x"></FontAwesomeIcon>
                </div>
            </div>
        </header>
    );
}

export default Header;
