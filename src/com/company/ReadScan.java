package com.company;

import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

public class ReadScan {
    private SerialPort serialPort;
    public void read(WorkData workData){
        //Передаём в конструктор имя порта
        serialPort = new SerialPort("COM22");
        try {
            //Открываем порт
            serialPort.openPort();
            //Выставляем параметры
            serialPort.setParams(SerialPort.BAUDRATE_9600,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
            //Включаем аппаратное управление потоком
            serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN |
                    SerialPort.FLOWCONTROL_RTSCTS_OUT);
            //Устанавливаем ивент лисенер и маску
            PortReader newportReader = new PortReader(workData);
            serialPort.addEventListener(newportReader, SerialPort.MASK_RXCHAR);

            //Отправляем запрос устройству
            //serialPort.writeString("Get data");
            //currentArrayHex= serialPort.readHexStringArray();
            //System.out.println(currentArrayHex);
        }
        catch (SerialPortException ex) {
            System.out.println(ex);
        }

    }


    public  class PortReader implements SerialPortEventListener {
        WorkData workData;

        public PortReader(WorkData workData) {
            this.workData = workData;
        }

        public void serialEvent(SerialPortEvent event) {
            if(event.isRXCHAR() && event.getEventValue() > 0){
                try {
                    //Получаем ответ от устройства, обрабатываем данные и т.д.
                    String[] data= serialPort.readHexStringArray();
                    workData.processing(data);
                    //SerialPort.closePort();
                    //serialPort.writeString("Get data");
                }
                catch (SerialPortException ex) {
                    System.out.println(ex);
                }
            }

            //Arrays.stream(data).forEach(x-> System.out.print(x));
            //currentArrayHex = data.clone();
            //currentArrayHex = data;
        }
    }

}
