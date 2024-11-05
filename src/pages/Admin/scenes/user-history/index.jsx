import React, { useState } from 'react';
import { Box, useTheme } from '@mui/material';
import { DataGrid, viVN } from '@mui/x-data-grid';
import { tokens } from '~/utils/theme/theme';
import Header from '../../components/Header';
import ConfirmBox from '../../components/ConfirmBox';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
const Branch = () => {
    const [teamData, setTeamData] = useState([]);
    const [open, setOpen] = useState(false);

    const theme = useTheme();
    const colors = tokens(theme.palette.mode);
    const columns = [
        { field: 'id', headerName: 'ID' },
        {
            field: 'date',
            headerName: 'Ngày tháng',
            flex: 1,
        },
        {
            field: 'discount',
            headerName: 'Giảm giá',
            type: 'text',
            headerAlign: 'left',
            align: 'left',
            flex: 1,
        },
        {
            field: 'status',
            headerName: 'Trạng thái',
            type: 'text',
            headerAlign: 'left',
            align: 'left',
            flex: 1,
            renderCell: ({ row: { status } }) => {
                return <span>{status === 0 ? 'Đóng cửa' : 'Mở cửa'}</span>;
            },
        },
        {
            field: 'payment',
            headerName: 'Mã giao dịch',
            flex: 1,
        },
        {
            field: 'staffId',
            headerName: 'Mã nhân viên',
            flex: 1,
        },
        {
            field: 'totalPrice',
            headerName: 'Tổng tiền',
            flex: 1,
        },
        {
            field: 'phone',
            headerName: 'Số điện thoại người đặt hàng',
            flex: 1,
        },
        {
            field: 'branch',
            headerName: 'Chi nhánh',
            flex: 1,
        },
    ];

    return (
        <>
            <div className="container">
                <Box m="20px">
                    <Header title="Lịch sử giao dịch" subtitle="Quản lý lịch sử giao dịch" />
                    <Box
                        m="40px 0 0 0"
                        height="75vh"
                        sx={{
                            '& .MuiDataGrid-root': {
                                border: 'none',
                            },
                            '& .MuiDataGrid-cell': {
                                borderBottom: 'none',
                            },
                            '& .name-column--cell': {
                                color: colors.greenAccent[300],
                            },
                            '& .MuiDataGrid-columnHeaders': {
                                backgroundColor: colors.blueAccent[700],
                                borderBottom: 'none',
                            },
                            '& .MuiDataGrid-virtualScroller': {
                                backgroundColor: colors.primary[400],
                            },
                            '& .MuiDataGrid-footerContainer': {
                                borderTop: 'none',
                                backgroundColor: colors.blueAccent[700],
                            },
                            '& .MuiCheckbox-root': {
                                color: `${colors.greenAccent[200]} !important`,
                            },
                        }}
                    >
                        <DataGrid
                            rows={teamData}
                            columns={columns}
                            localeText={viVN.components.MuiDataGrid.defaultProps.localeText}
                        />
                    </Box>
                </Box>
                <ConfirmBox open={open} closeDialog={() => setOpen(false)} title={'Bạn có chắc muốn xóa chi nhánh!'} />
                <ToastContainer />
            </div>
        </>
    );
};

export default Branch;
