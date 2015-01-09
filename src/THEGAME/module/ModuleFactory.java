package THEGAME.module;

/**
 * Created by Mihael on 1/9/2015.
 */
public class ModuleFactory {

    public static VehicleModule createModule(ModuleEnum classId, int _x, int _y){
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

        tmp.posx = _x; tmp.posy = _y;
        tmp.position.set( VehicleModule.moduleW * tmp.posx, VehicleModule.moduleH * tmp.posy );
        tmp.size.set( VehicleModule.moduleW * tmp.w, VehicleModule.moduleH * tmp.h );

        return tmp;
    }



}
