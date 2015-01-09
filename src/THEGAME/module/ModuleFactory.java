package THEGAME.module;

/**
 * Created by Mihael on 1/9/2015.
 */
public class ModuleFactory {

    public static VehicleModule createModule(ModuleEnum classId, int _w, int _h){
        VehicleModule tmp = null;
        if(classId == ModuleEnum.PROPULSIONMODULE){
            tmp = new PropulsionModule();
        }
        if(classId == ModuleEnum.FUELMODULE){
            tmp = new FuelModule();
        }
        if(classId == ModuleEnum.FRAMEMODULE){
            tmp = new FrameModule();
        }
        if(classId == ModuleEnum.ENGINEMODULE){
            tmp = new EngineModule();
        }
        if(classId == ModuleEnum.COOLERMODULE){
            tmp = new CoolerModule();
        }

        tmp.w = _w; tmp.h = _h;
        tmp.position.set( VehicleModule.moduleW * tmp.w, VehicleModule.moduleH * tmp.h );
        tmp.size.set( VehicleModule.moduleW, VehicleModule.moduleH );

        return tmp;
    }



}
